package edu.cl.learn.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Clay
 * @Date: 2021/2/13 4:53 下午
 */
@Data
public class IndexVO {
    /**
     * 试卷总数
     */
    private Integer examPaperCount;
    /**
     * 问题总数
     */
    private Integer questionCount;
    /**
     *
     */
    private Integer doExamPaperCount;
    /**
     *
     */
    private Integer doQuestionCount;
    /**
     *
     */
    private List<Integer> mothDayUserActionValue;
    /**
     *
     */
    private List<Integer> mothDayDoExamQuestionValue;
    /**
     *
     */
    private List<String> mothDayText;
}
