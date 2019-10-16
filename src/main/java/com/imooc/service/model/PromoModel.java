package com.imooc.service.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * 秒杀模型
 */
@Data
public class PromoModel {
    //id
    private String id;

    // 状态：   0为未开始，1进行中，2已结束
    private int status;

    // 活动名称
    private String promoName;

    //活动开始时间
    private DateTime start;

    //活动结束时间
    private DateTime end;

    // 秒杀商品
    private String itemId;

    // 秒杀价格
    private BigDecimal promoPrice;

}
