package com.imooc.service.model;

import lombok.Data;

@Data
public class UserModel {
    private String id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telephone;
    private String registerMod;
    private String thirdPartId;
    private String encryptPassword;
    private String email;
}
