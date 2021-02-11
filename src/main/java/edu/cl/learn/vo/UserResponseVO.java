package edu.cl.learn.vo;

import lombok.Data;

/**
 * @Author: Clay
 * @Date: 2021/2/12 1:47 上午
 */
@Data
public class UserResponseVO {

    private Integer id;

    private String userUuid;

    private String userName;

    private String realName;

    private Integer age;

    private Integer role;

    private Integer sex;

    private String birthDay;

    private String phone;

    private String lastActiveTime;

    private String createTime;

    private String modifyTime;

    private Integer status;

    private Integer userLevel;

    private String imagePath;
}
