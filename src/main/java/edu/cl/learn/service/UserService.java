package edu.cl.learn.service;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.KeyValue;
import edu.cl.learn.domain.User;
import edu.cl.learn.vo.user.UserPageRequestVO;

import java.util.List;

/**
 * @Author: Clay
 * @Date: 2021/2/12 1:57 上午
 */
public interface UserService {
    PageInfo<User> userPage(UserPageRequestVO model);


    User getUserById(Integer id);

    void updateByIdFilter(User user);

    User selectById(Integer id);

    List<KeyValue> selectByUserName(String userName);

    User getUserByUserName(String userName);

    void insertByFilter(User user);
}
