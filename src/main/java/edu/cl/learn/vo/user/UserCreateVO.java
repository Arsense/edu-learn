package edu.cl.learn.vo.user;

import lombok.Data;

/**
 * 用户创建VO
 * @Author: Clay
 * @Date: 2021/2/12 1:49 上午
 */
@Data
public class UserCreateVO {


    private Integer id;

    private String userName;

    private String password;

    private String realName;

    private String age;

    private Integer status;

    private Integer sex;

    private String birthDay;

    private String phone;

    private Integer role;

    private Integer userLevel;
}
