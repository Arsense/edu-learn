package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.ExamPaperAnswer;
import edu.cl.learn.service.ExamPaperAnswerService;
import edu.cl.learn.vo.answer.ExamPaperAnswerPageRequestVO;
import org.springframework.stereotype.Service;

/**
 * @Author: Clay
 * @Date: 2021/2/12 11:50 下午
 */
@Service
public class ExamPaperAnswerServiceImpl implements ExamPaperAnswerService {
    @Override
    public PageInfo<ExamPaperAnswer> adminPage(ExamPaperAnswerPageRequestVO model) {
        return null;
    }
}
