package edu.cl.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.cl.learn.dao.UserMapper;
import edu.cl.learn.domain.KeyValue;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.UserService;
import edu.cl.learn.vo.user.UserPageRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Clay
 * @Date: 2021/2/12 1:57 上午
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> userPage(UserPageRequestVO requestVO) {
        return PageHelper.startPage(requestVO.getPageIndex(), requestVO.getPageSize(), "id desc")
                         .doSelectPageInfo(() -> userMapper.userPage(requestVO));
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void updateByIdFilter(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<KeyValue> selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public void insertByFilter(User user) {
         userMapper.insertSelective(user);
    }
}
