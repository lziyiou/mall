package com.imooc.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 秒杀模型
 */
@Data
public class Promo {
    //id
    private String id;

    // 活动名称
    private String promoName;

    //活动开始时间
    private Date start;

    //活动结束时间
    private Date end;

    // 秒杀商品
    private String itemId;

    // 秒杀价格
    private BigDecimal promoPrice;

}
