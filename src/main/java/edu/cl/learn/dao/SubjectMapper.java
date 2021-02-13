package edu.cl.learn.dao;

import edu.cl.learn.domain.Subject;
import edu.cl.learn.vo.subject.SubjectPageRequestVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author: Clay
 * @Date: 2021/2/13 11:40 下午
 */
@Mapper
public interface SubjectMapper {

   int deleteById(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    int updateSubjectSelective(Subject record);

    int updateSubject(Subject record);

    List<Subject> queryByLevel(Integer level);

    List<Subject> allSubject();

    List<Subject> page(SubjectPageRequestVO requestVO);
}
