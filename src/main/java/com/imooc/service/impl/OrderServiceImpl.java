package com.imooc.service.impl;

import com.imooc.bean.Order;
import com.imooc.error.BusinessException;
import com.imooc.error.EmBusinessError;
import com.imooc.mapper.OrderMapper;
import com.imooc.service.ItemService;
import com.imooc.service.OrderService;
import com.imooc.service.UserService;
import com.imooc.service.model.ItemModel;
import com.imooc.service.model.OrderModel;
import com.imooc.service.model.UserModel;
import com.imooc.util.ConvertUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    private final ItemService itemService;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(ItemService itemService, UserService userService, OrderMapper orderMapper) {
        this.itemService = itemService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public OrderModel createOrder(String userId, String itemId, Integer amount) throws BusinessException {
        //校验用户是否合法，商品是否存在，数量是否正确
        ItemModel itemModel = itemService.getItemById(itemId);
        if (itemModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商品信息不正确");
        }

        UserModel userModel = userService.getUserById(userId);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户信息不正确");
        }

        if (amount <= 0 || amount > itemModel.getStock()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "数量信息不正确");
        }

        //落单减库存
        if (!itemService.decreaseStock(itemId, amount)) {
            throw new BusinessException(EmBusinessError.STOCK_NOT_ENOUGH);
        }

        //订单入库
        OrderModel orderModel = new OrderModel();
        orderModel.setUserId(userId);
        orderModel.setItemId(itemId);
        orderModel.setAmount(amount);
        orderModel.setOrderPrice(itemModel.getPrice());
        orderModel.setOrderAmount(itemModel.getPrice().multiply(new BigDecimal(orderModel.getAmount())));

        Order order = ConvertUtil.convertTFromPojo(Order.class, orderModel);
        orderMapper.insert(order);

        //返回前端

        return orderModel;
    }
}
