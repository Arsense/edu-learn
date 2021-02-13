package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.TaskExam;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.TaskExamService;
import edu.cl.learn.vo.task.TaskPageRequestVO;
import edu.cl.learn.vo.task.TaskRequestVO;
import org.springframework.stereotype.Service;

/**
 * @Author: Clay
 * @Date: 2021/2/12 4:51 下午
 */
@Service
public class TaskExamServiceImpl implements TaskExamService {
    @Override
    public TaskRequestVO taskExamToVM(Integer id) {
        return null;
    }

    @Override
    public TaskExam selectById(Integer id) {
        return null;
    }

    @Override
    public void updateByIdFilter(TaskExam taskExam) {

    }

    @Override
    public PageInfo<TaskExam> page(TaskPageRequestVO model) {
        return null;
    }

    @Override
    public void edit(TaskRequestVO model, User currentUser) {

    }
}
