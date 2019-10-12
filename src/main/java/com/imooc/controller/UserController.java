package com.imooc.controller;

import com.imooc.controller.viewObject.UserVO;
import com.imooc.error.BusinessException;
import com.imooc.error.EmBusinessError;
import com.imooc.response.CommonReturnType;
import com.imooc.service.EmailService;
import com.imooc.service.UserService;
import com.imooc.service.model.UserModel;
import com.imooc.util.ConvertUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final EmailService emailService;
    private final HttpSession session;

    public UserController(UserService userService, EmailService emailService, HttpSession httpSession) {
        this.userService = userService;
        this.emailService = emailService;
        this.session = httpSession;
    }

    /**
     * 用户登录
     * @param email 邮箱参数
     * @param password  密码参数
     * @return  CommonReturnType
     */
    @PostMapping("login")
    public CommonReturnType login(@RequestParam("email")String email,@RequestParam("password")String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //入参校验
        if(StringUtils.isEmpty(email)||StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //用户登录服务
        UserVO userVo = userService.login(email, password);
        session.setAttribute("user", userVo);

        return new CommonReturnType(null);
    }

    /**
     * 用户注册
     * @param userModel 页面传参
     * @param otpCode   验证码参数
     * @return  CommonReturnType
     */
    @PostMapping("register")
    public CommonReturnType register(UserModel userModel, @RequestParam("otpCode")String otpCode) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //验证码
        String codeInSession = (String) session.getAttribute(userModel.getEmail());
        if(!StringUtils.equals(otpCode, codeInSession)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "验证码不正确");
        }
        //用户注册流程
        //设置用户注册方式
        userModel.setRegisterMod("byEmail");

        userService.register(userModel);

        return new CommonReturnType(null);
    }

    /**
     * 获取验证码
     * @param email 要验证的邮箱
     * @return  otp验证码
     */
    @PostMapping("getotp")
    public CommonReturnType getOtp(@RequestParam("email") String email) {
        //生成OTP验证码
        Random random = new Random();
        StringBuilder otpCodeSB = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otpCodeSB.append(random.nextInt(10));
        }

        //绑定email与otpCode
        String otpCode = otpCodeSB.toString();
        session.setAttribute(email, otpCode);

        //发送到该邮箱
//        System.out.println("telephone:" + email + " & otpCode:" + otpCode.toString());
        emailService.sendOtp(email, otpCode);

        return new CommonReturnType(null);
    }

    /**
     * 通过id获取用户
     * @param id    用户id
     * @return  userVo->CommonReturnType
     * @throws BusinessException    参数错误等异常
     */
    @RequestMapping("get")
    public CommonReturnType getUser(@RequestParam("id") String id) throws BusinessException {
        //调用service服务获取对应id的用户对象并返回到前端
        UserModel userModel = userService.getUserById(id);

        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

//        UserVO userVO = convertFromUserModel(userModel);
        UserVO userVO = ConvertUtil.convertTFromPojo(UserVO.class, userModel);
        return new CommonReturnType(userVO);
    }

}
