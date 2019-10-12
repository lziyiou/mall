package com.imooc.service.impl;

import com.imooc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendOtp(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("mall商城注册验证码");
        String from = "mall商场注册验证码";
        message.setFrom(from);
        message.setText(otp);
        mailSender.send(message);
    }
}
