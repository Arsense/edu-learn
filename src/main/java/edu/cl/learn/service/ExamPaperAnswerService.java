package edu.cl.learn.service;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.ExamPaperAnswer;
import edu.cl.learn.vo.answer.ExamPaperAnswerPageRequestVO;

/**
 * @Author: Clay
 * @Date: 2021/2/12 11:50 下午
 */
public interface ExamPaperAnswerService {
    PageInfo<ExamPaperAnswer> adminPage(ExamPaperAnswerPageRequestVO model);
}
