package com.imooc.service;

public interface EmailService {
    //发送otp
    void sendOtp(String to, String otp);
}
