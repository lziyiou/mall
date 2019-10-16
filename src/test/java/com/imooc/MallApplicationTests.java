package com.imooc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.bean.Promo;
import com.imooc.mapper.PromoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

    @Autowired
    private PromoMapper promoMapper;

    @Test
    public void test() {
        QueryWrapper<Promo> wrapper = new QueryWrapper<>();
        wrapper.select("start");
        Promo promo = promoMapper.selectOne(wrapper);
        System.out.println("promo = " + promo);
    }

}
