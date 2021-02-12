package edu.cl.learn.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Clay
 * @Date: 2021/2/13 12:44 上午
 */
@Data
public class UserEventLog {

    private Integer id;

    private Integer userId;

    private String userName;

    private String realName;

    private String content;

    private Date createTime;

}
