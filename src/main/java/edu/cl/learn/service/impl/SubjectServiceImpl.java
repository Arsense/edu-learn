package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.Subject;
import edu.cl.learn.service.SubjectService;
import edu.cl.learn.vo.subject.SubjectPageRequestVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:39 下午
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Override
    public PageInfo<Subject> page(SubjectPageRequestVO model) {
        return null;
    }

    @Override
    public List<Subject> allSubject() {
        return null;
    }

    @Override
    public void insertByFilter(Subject subject) {

    }

    @Override
    public void updateByIdFilter(Subject subject) {

    }
}
