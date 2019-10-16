package com.imooc.test;

import com.imooc.error.BusinessException;
import com.imooc.service.UserService;
import com.imooc.service.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RegTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        UserModel userModel = new UserModel();
        userModel.setRegisterMod("byemail");
        userModel.setEncryptPassword("pwd");
        userModel.setAge(13);
        userModel.setEmail("email");
        userModel.setGender((byte) 1);
        userModel.setName("good");
        userService.register(userModel);
    }

    @Test
    public void testLambda() {

    }

}
