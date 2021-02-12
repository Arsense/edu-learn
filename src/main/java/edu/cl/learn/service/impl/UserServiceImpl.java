package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.KeyValue;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.UserService;
import edu.cl.learn.vo.user.UserPageRequestVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Clay
 * @Date: 2021/2/12 1:57 上午
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public PageInfo<User> userPage(UserPageRequestVO model) {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public void updateByIdFilter(User user) {

    }

    @Override
    public User selectById(Integer id) {
        return null;
    }

    @Override
    public List<KeyValue> selectByUserName(String userName) {
        return null;
    }
}
