package edu.cl.learn.dao;

import com.mindskip.xzs.domain.ExamPaperQuestionCustomerAnswer;
import com.mindskip.xzs.domain.other.ExamPaperAnswerUpdate;
import com.mindskip.xzs.domain.other.KeyValue;
import com.mindskip.xzs.viewmodel.student.question.answer.QuestionPageStudentRequestVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExamPaperQuestionCustomerAnswerMapper extends BaseMapper<ExamPaperQuestionCustomerAnswer> {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPaperQuestionCustomerAnswer record);

    int insertSelective(ExamPaperQuestionCustomerAnswer record);

    ExamPaperQuestionCustomerAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPaperQuestionCustomerAnswer record);

    int updateByPrimaryKey(ExamPaperQuestionCustomerAnswer record);

    List<ExamPaperQuestionCustomerAnswer> selectListByPaperAnswerId(Integer id);

    List<ExamPaperQuestionCustomerAnswer> studentPage(QuestionPageStudentRequestVM requestVM);

    int insertList(List<ExamPaperQuestionCustomerAnswer> list);

    Integer selectAllCount();

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    int updateScore(List<ExamPaperAnswerUpdate> examPaperAnswerUpdates);
}
