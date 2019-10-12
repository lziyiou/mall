package com.imooc.bean;

import lombok.Data;

@Data
public class UserPassword {

    private String id;

    private String encryptPassword;

    private String userId;

}