package edu.cl.learn.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Clay
 * @Date: 2021/2/12 11:50 下午
 */
@Data
public class ExamPaperAnswer {

    private Integer id;

    private String name;

    private Integer subjectId;

    private Integer paperType;

    private Integer gradeLevel;

    private Integer score;

    private Integer questionCount;

    private Integer suggestTime;

    private Date limitStartTime;

    private Date limitEndTime;

    private Integer frameTextContentId;

    private Integer createUser;

    private Date createTime;

    private Boolean deleted;

    private Integer taskExamId;

}
