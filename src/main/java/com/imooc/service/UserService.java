package com.imooc.service;

import com.imooc.controller.viewObject.UserVO;
import com.imooc.error.BusinessException;
import com.imooc.service.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService {
    //通过id获取用户对象
    UserModel getUserById(String id);

    void register(UserModel userModel) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 用户登录服务
     * @param telephone 用户注册手机
     * @param encryptPassword  用户加密后的密码
     * @throws BusinessException
     */
    UserVO login(String telephone, String encryptPassword) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;
}
