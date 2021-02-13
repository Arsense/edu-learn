package edu.cl.learn.dao;

import edu.cl.learn.domain.ExamPaper;
import edu.cl.learn.domain.KeyValue;
import edu.cl.learn.vo.exam.ExamPaperPageRequestVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExamPaperMapper  {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPaper record);

    int insertSelective(ExamPaper record);

    ExamPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPaper record);

    int updateByPrimaryKey(ExamPaper record);

    List<ExamPaper> page(ExamPaperPageRequestVO requestVM);

    List<ExamPaper> taskExamPage(ExamPaperPageRequestVO requestVM);

//    List<ExamPaper> studentPage(ExamPaperPageVO requestVM);

//    List<PaperInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

//    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    int updateTaskPaper(@Param("taskId") Integer taskId,@Param("paperIds") List<Integer> paperIds);

    int clearTaskPaper(@Param("paperIds") List<Integer> paperIds);
}
