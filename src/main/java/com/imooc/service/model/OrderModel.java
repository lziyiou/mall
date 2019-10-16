package com.imooc.service.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单模型
 */
@Data
public class OrderModel {
    //id
    private String id;
    //用户id
    private String userId;
    //商品id
    private String itemId;
    //购买数量
    private Integer amount;
    //购买金额
    private BigDecimal orderAmount;

    //冗余一个商品购买时的单价
    private BigDecimal orderPrice;

}
