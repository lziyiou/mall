package com.imooc;

import com.imooc.service.ItemService;
import com.imooc.service.UserService;
import com.imooc.service.model.UserModel;
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
        UserModel user = userService.getUserById("7b830c10-c652-4e6b-a682-d52f0f6a2e21");
        System.out.println("user = " + user);
    }

}
