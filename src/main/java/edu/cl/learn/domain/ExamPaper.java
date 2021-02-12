package edu.cl.learn.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:43 下午
 */
@Data
public class ExamPaper implements Serializable {

    private Integer id;

    /**
     * 试卷名称
     */
    private String name;

    /**
     * 试卷名称
     */
    private Integer subjectId;

    /**
     * 试卷名称
     */
    private Integer paperType;

    /**
     * 试卷名称
     */
    private Integer gradeLevel;
    /**
     * 试卷名称
     */
    private Integer score;
    /**
     * 试卷名称
     */
    private Integer questionCount;
    /**
     * 试卷名称
     */
    private Integer suggestTime;
    /**
     * 试卷名称
     */
    private Date limitStartTime;
    /**
     * 试卷名称
     */
    private Date limitEndTime;
    /**
     * 试卷名称
     */
    private Integer frameTextContentId;
    /**
     * 试卷名称
     */
    private Integer createUser;
    /**
     * 试卷名称
     */
    private Date createTime;
    /**
     * 试卷名称
     */
    private Boolean deleted;
    /**
     * 试卷名称
     */
    private Integer taskExamId;
}
