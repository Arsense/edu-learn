package edu.cl.learn.service;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.Subject;
import edu.cl.learn.vo.subject.SubjectPageRequestVO;

import java.util.List;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:39 下午
 */
public interface SubjectService {
    PageInfo<Subject> page(SubjectPageRequestVO model);

    List<Subject> allSubject();

    void insertByFilter(Subject subject);

    void updateByIdFilter(Subject subject);
}
