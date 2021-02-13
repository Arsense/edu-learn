package edu.cl.learn;

import com.alibaba.fastjson.JSON;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.UserService;
import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Clay
 * @Date: 2021/2/13 12:14 下午
 */
public class UserServiceTest extends BaseTest{



    @Autowired
    private UserService userService;


    @Test
    public void testService(){

        User user = userService.getUserById(1);
        Assert.notNull(user);
        System.out.println("查询用户结果是" + JSON.toJSONString(user));
    }
}

