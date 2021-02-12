package edu.cl.learn.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Clay
 * @Date: 2021/2/12 4:51 下午
 */
@Data
public class TaskExam  implements Serializable {

    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private String title;
    /**
     * 级别
     */
    private Integer gradeLevel;
    /**
     * 任务框架 内容为JSON
     */
    private Integer frameTextContentId;
    /**
     *
     */
    private Integer createUser;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Boolean deleted;
    /**
     *
     */
    private String createUserName;
}
