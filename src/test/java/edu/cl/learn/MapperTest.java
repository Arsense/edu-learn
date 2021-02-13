package edu.cl.learn;

import edu.cl.learn.dao.UserMapper;
import edu.cl.learn.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: Clay
 * @Date: 2021/2/13 12:27 下午
 */
public class MapperTest extends BaseTest{


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserMapper(){
        User user = new User();
        user.setAge(22);
        user.setBirthDay(new Date());
        user.setUserUuid(UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
        user.setPassword("111");
        user.setStatus(1);
        user.setUserName("张三");
        int id = userMapper.insert(user);
        System.out.println("插入成功" + id);


    }

    @Test
    public void testQuery(){

    }

}
