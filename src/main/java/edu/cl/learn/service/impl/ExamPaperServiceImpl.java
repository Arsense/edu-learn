package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.ExamPaper;
import edu.cl.learn.service.ExamPaperService;
import edu.cl.learn.vo.exam.ExamPaperPageRequestVO;
import org.springframework.stereotype.Service;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:38 下午
 */
@Service
public class ExamPaperServiceImpl implements ExamPaperService {


    @Override
    public PageInfo<ExamPaper> page(ExamPaperPageRequestVO model) {
        return null;
    }
}
