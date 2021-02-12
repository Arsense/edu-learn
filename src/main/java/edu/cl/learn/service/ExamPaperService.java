package edu.cl.learn.service;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.ExamPaper;
import edu.cl.learn.vo.exam.ExamPaperPageRequestVO;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:37 下午
 */
public interface ExamPaperService {
    PageInfo<ExamPaper> page(ExamPaperPageRequestVO model);
}
