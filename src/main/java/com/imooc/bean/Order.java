package com.imooc.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("order_info")
public class Order {

    private String id;

    private String userId;

    private String itemId;

    private Integer amount;

    private BigDecimal orderAmount;

    private BigDecimal orderPrice;
}