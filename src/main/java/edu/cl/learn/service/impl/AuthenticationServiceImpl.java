package edu.cl.learn.service.impl;

import edu.cl.learn.service.AuthenticationService;
import org.springframework.stereotype.Service;

/**
 * @Author: Clay
 * @Date: 2021/2/13 11:21 下午
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {




    @Override
    public String encode(String password) {
        return null;
    }

    @Override
    public String decode(String endodePwd) {
        return null;
    }
}
