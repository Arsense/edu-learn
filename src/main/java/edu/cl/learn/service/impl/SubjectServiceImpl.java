package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.dao.SubjectMapper;
import edu.cl.learn.domain.Subject;
import edu.cl.learn.service.SubjectService;
import edu.cl.learn.vo.subject.SubjectPageRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学科管理mapper
 * @Author: Clay
 * @Date: 2021/2/12 2:39 下午
 */
@Service
public class SubjectServiceImpl implements SubjectService {


    @Resource
    private SubjectMapper subjectMapper;


    @Override
    public PageInfo<Subject> page(SubjectPageRequestVO model) {
        return null;
    }

    @Override
    public List<Subject> allSubject() {
        return subjectMapper.allSubject();
    }

    @Override
    public void insertByFilter(Subject subject) {
        subjectMapper.insertSelective(subject);
    }

    @Override
    public void updateByIdFilter(Subject subject) {
        subjectMapper.updateSubjectSelective(subject);
    }

    @Override
    public Subject selectById(Integer id) {
        return subjectMapper.selectByPrimaryKey(id);
    }
}
