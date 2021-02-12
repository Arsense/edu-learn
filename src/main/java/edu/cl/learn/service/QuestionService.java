package edu.cl.learn.service;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.Question;
import edu.cl.learn.vo.question.QuestionEditRequestVO;
import edu.cl.learn.vo.question.QuestionPageRequestVO;

/**
 * @Author: Clay
 * @Date: 2021/2/13 1:11 上午
 */
public interface QuestionService {
    QuestionEditRequestVO getQuestionEditRequestVO(Integer id);

    Question selectById(Integer id);

    void updateByIdFilter(Question question);

    void insertFullQuestion(QuestionEditRequestVO model, Integer id);

    void updateFullQuestion(QuestionEditRequestVO model);

    PageInfo<Question> page(QuestionPageRequestVO model);
}
