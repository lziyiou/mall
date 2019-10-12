package com.imooc.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    private String id;

    private String name;

    private BigDecimal price;

    private Integer sales;

    private String description;

    private String imgUri;
}