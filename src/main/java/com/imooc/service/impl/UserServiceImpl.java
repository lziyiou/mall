package com.imooc.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imooc.bean.User;
import com.imooc.bean.UserPassword;
import com.imooc.controller.viewObject.UserVO;
import com.imooc.error.BusinessException;
import com.imooc.error.EmBusinessError;
import com.imooc.mapper.UserMapper;
import com.imooc.mapper.UserPasswordMapper;
import com.imooc.service.UserService;
import com.imooc.service.model.UserModel;
import com.imooc.util.ConvertUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserPasswordMapper userPasswordMapper;
    private UserMapper userMapper;

    public UserServiceImpl(UserPasswordMapper userPasswordMapper, UserMapper userMapper) {
        this.userPasswordMapper = userPasswordMapper;
        this.userMapper = userMapper;
    }

    @Override
    public UserModel getUserById(String id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return null;
        }

        UserPassword userPassword = userPasswordMapper.selectOne(Wrappers.<UserPassword>lambdaQuery().eq(UserPassword::getUserId, user.getId()));

        return convertFromDataObject(user, userPassword);
    }

    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException, NoSuchAlgorithmException {
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //设置用户id
        userModel.setId(UUID.randomUUID().toString());

        //设置用户加密密码
        userModel.setEncryptPassword(EncoderByMd5(userModel.getEncryptPassword()));

//        User user = convertUserFromUserModel(userModel);
        User user = ConvertUtil.convertTFromPojo(User.class, userModel);
        userMapper.insert(user);

        UserPassword userPassword = convertUserPasswordFromUserModel(userModel);
        userPasswordMapper.insert(userPassword);

    }

    @Override
    public UserVO login(String email, String encryptPassword) throws BusinessException, NoSuchAlgorithmException {
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getEmail, email));

        if (user == null) {
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }
        UserPassword userPassword = userPasswordMapper.selectOne(Wrappers.<UserPassword>lambdaQuery().eq(UserPassword::getUserId, user.getId()));

        UserModel userModel = convertFromDataObject(user, userPassword);
        if (!StringUtils.equals(EncoderByMd5(encryptPassword), userModel.getEncryptPassword())) {
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }

//        return convertUserVoFromUserModel(userModel);
        return ConvertUtil.convertTFromPojo(UserVO.class, userModel);
    }

    private UserPassword convertUserPasswordFromUserModel(UserModel userModel) {
        //用户为空，返回空
        if (userModel == null) {
            return null;
        }
        UserPassword userPassword = new UserPassword();
        userPassword.setUserId(userModel.getId());
        userPassword.setEncryptPassword(userModel.getEncryptPassword());
        return userPassword;
    }

    private UserModel convertFromDataObject(User user, UserPassword userPassword) {
        //用户为空，返回空
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        //密码为空，则不设置密码
        if (userPassword != null) {
            userModel.setEncryptPassword(userPassword.getEncryptPassword());
        }
        return userModel;

    }

    /**
     * 利用MD5进行加密
     */
    private String EncoderByMd5(String str) throws NoSuchAlgorithmException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        return Base64.encodeBase64String(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
    }
}
