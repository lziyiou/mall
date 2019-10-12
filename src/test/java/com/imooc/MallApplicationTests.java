package com.imooc;

import com.imooc.bean.Order;
import com.imooc.error.BusinessException;
import com.imooc.mapper.OrderMapper;
import com.imooc.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test() throws BusinessException {
        orderService.createOrder("c2bc1baa-7ba6-4792-bd4b-e6b7818719ba","cb0d113e-4bff-4203-abd8-34ae5c1381fe", 1);
    }

    @Test
    public void testOrderMapper(){
        Order order = new Order();
        order.setId("good");
        order.setAmount(1);
        order.setItemId("itemid");
        order.setOrderAmount(new BigDecimal(1.1));
        order.setOrderPrice(new BigDecimal(2.2));
        order.setUserId("userid");
        orderMapper.insert(order);
    }

}
