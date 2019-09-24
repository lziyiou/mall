package com.imooc.controller;

import com.imooc.controller.viewObject.UserVO;
import com.imooc.error.BusinessException;
import com.imooc.error.EmBusinessError;
import com.imooc.response.CommonReturnType;
import com.imooc.service.OrderService;
import com.imooc.service.model.OrderModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    private final OrderService orderService;
    private final HttpSession session;

    public OrderController(OrderService orderService, HttpSession session) {
        this.orderService = orderService;
        this.session = session;
    }

    @PostMapping("corder")
    public CommonReturnType createOrder(@RequestParam("itemId") String itemId, @RequestParam("amount") Integer amount) throws BusinessException {
        //检查用户是否登录
        UserVO userVO = (UserVO) session.getAttribute("user");
        if (userVO == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户未登录，不能下单");
        }

        OrderModel order = orderService.createOrder(userVO.getId(), itemId, amount);
        return new CommonReturnType(null);
    }
}
