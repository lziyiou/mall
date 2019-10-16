package com.imooc.controller.viewObject;

import lombok.Data;

@Data
public class UserVO {
    private String id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telephone;
    private String email;
}
