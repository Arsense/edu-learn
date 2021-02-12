package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.UserService;
import edu.cl.learn.vo.UserPageRequestVO;
import org.springframework.stereotype.Service;

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
}
