package edu.cl.learn.service;

/**
 *
 * 密码加解密服务
 * @Author: Clay
 * @Date: 2021/2/13 11:21 下午
 */
public interface AuthenticationService {

    /**
     * 密码加密 RSA方法
     *
     * @param password password
     * @return String
     */
    String encode(String password);

    /**
     * 密码解密RSA方法
     *
     * @param endodePwd endodePwd
     * @return String
     */
    String decode(String endodePwd);
}
