package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.Question;
import edu.cl.learn.service.QuestionService;
import edu.cl.learn.vo.question.QuestionEditRequestVO;
import edu.cl.learn.vo.question.QuestionPageRequestVO;
import org.springframework.stereotype.Service;

/**
 * @Author: Clay
 * @Date: 2021/2/13 1:11 上午
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public QuestionEditRequestVO getQuestionEditRequestVO(Integer id) {
        return null;
    }

    @Override
    public Question selectById(Integer id) {
        return null;
    }

    @Override
    public void updateByIdFilter(Question question) {

    }

    @Override
    public void insertFullQuestion(QuestionEditRequestVO model, Integer id) {

    }

    @Override
    public void updateFullQuestion(QuestionEditRequestVO model) {

    }

    @Override
    public PageInfo<Question> page(QuestionPageRequestVO model) {
        return null;
    }
}
