package edu.cl.learn.service;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.TaskExam;
import edu.cl.learn.domain.User;
import edu.cl.learn.vo.task.TaskPageRequestVO;
import edu.cl.learn.vo.task.TaskRequestVO;

/**
 * @Author: Clay
 * @Date: 2021/2/12 4:50 下午
 */
public interface TaskExamService {
    TaskRequestVO taskExamToVM(Integer id);

    TaskExam selectById(Integer id);

    void updateByIdFilter(TaskExam taskExam);

    PageInfo<TaskExam> page(TaskPageRequestVO model);

    void edit(TaskRequestVO model, User currentUser);
}
