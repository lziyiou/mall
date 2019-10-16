package com.imooc.controller.viewObject;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemVo {
    private String id;
    private String name;
    private BigDecimal price;
    private Integer stock;  //库存
    private Integer sales;  //销量
    private String description;
    private String imgUri;

    private int promoStatus;//活动状态
    private BigDecimal promoPrice;//活动价格
    private String promoId;//活动id
    private String promoStart;//活动开始时间
    private String promoEnd;
}
