package com.imooc.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info")
public class User {

    private String id;

    private String name;

    private Byte gender;

    private Integer age;

    private String telephone;

    private String registerMod;

    private String thirdPartId;

    private String email;

}