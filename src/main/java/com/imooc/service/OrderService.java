package com.imooc.service;

import com.imooc.error.BusinessException;
import com.imooc.service.model.OrderModel;

public interface OrderService {
    /**
     * 下单
     * @param userId    下单用户
     * @param itemId    下单商品
     * @param amount    购买数量
     * @return  订单模型
     */
    OrderModel createOrder(String userId, String itemId, Integer amount) throws BusinessException;
}
