package com.imooc.mail.test;

import com.imooc.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void test(){
        emailService.sendOtp("lziyiou@gmail.com", "562324");
    }
}
