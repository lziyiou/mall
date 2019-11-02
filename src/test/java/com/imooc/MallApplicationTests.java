package com.imooc;

import com.imooc.service.ItemService;
import com.imooc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Test
    public void test() {
        itemService.listItem().forEach(System.out::println);
    }

}
