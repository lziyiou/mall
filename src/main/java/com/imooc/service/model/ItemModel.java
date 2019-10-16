package com.imooc.service.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemModel {
    private String id;
    private String name;
    private BigDecimal price;
    private Integer stock;  //库存
    private Integer sales;  //销量
    private String description;
    private String imgUri;

    // 使用聚合模型
    private PromoModel promoModel;

}
