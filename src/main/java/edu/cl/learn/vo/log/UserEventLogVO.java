package edu.cl.learn.vo.log;

import lombok.Data;

/**
 * @Author: Clay
 * @Date: 2021/2/13 12:44 上午
 */
@Data
public class UserEventLogVO {

    private Integer id;

    private Integer userId;

    private String userName;

    private String realName;

    private String content;

    private String createTime;
}
