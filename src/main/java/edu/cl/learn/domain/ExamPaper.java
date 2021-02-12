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
     * 学科id
     */
    private Integer subjectId;

    /**
     * 试卷类型( 1固定试卷  2临时试卷 3班级试卷 4.时段试卷 5.推送试卷)
     */
    private Integer paperType;

    /**
     * 级别
     */
    private Integer gradeLevel;
    /**
     * 试卷总分(千分制)
     */
    private Integer score;
    /**
     * 建议时长(分钟)
     */
    private Integer questionCount;
    /**
     *  建议时长(分钟)
     */
    private Integer suggestTime;
    /**
     * 时段试卷 开始时间
     */
    private Date limitStartTime;
    /**
     * 时段试卷 结束时间
     */
    private Date limitEndTime;
    /**
     * 试卷框架 内容为JSON
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
