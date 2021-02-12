package edu.cl.learn.service;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.User;
import edu.cl.learn.vo.UserPageRequestVO;

/**
 * @Author: Clay
 * @Date: 2021/2/12 1:57 上午
 */
public interface UserService {
    PageInfo<User> userPage(UserPageRequestVO model);

    User getUserById(Integer id);

    void updateByIdFilter(User user);
}
