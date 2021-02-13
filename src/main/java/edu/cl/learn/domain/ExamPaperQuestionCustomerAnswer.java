package edu.cl.learn.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户作答的基础类
 * @Author: Clay
 * @Date: 2021/2/14 12:06 上午
 */
@Data
public class ExamPaperQuestionCustomerAnswer {

    private Integer id;

    private Integer questionId;

    private Integer examPaperId;

    private Integer examPaperAnswerId;

    private Integer questionType;

    private Integer subjectId;

    private Integer customerScore;

    private Integer questionScore;

    private Integer questionTextContentId;

    private String answer;

    private Integer textContentId;

    private Boolean doRight;

    private Integer createUser;

    private Date createTime;

    private Integer itemOrder;
}
