package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.domain.TaskExam;
import edu.cl.learn.service.TaskExamService;
import edu.cl.learn.util.DateTimeUtil;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.task.TaskPageRequestVO;
import edu.cl.learn.vo.task.TaskPageResponseVO;
import edu.cl.learn.vo.task.TaskRequestVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Clay
 * @Date: 2021/2/12 4:48 下午
 */
@Controller
@Api("任务管理")
public class TaskController extends BaseApiController {

    private final TaskExamService taskExamService;

    @Autowired
    public TaskController(TaskExamService taskExamService) {
        this.taskExamService = taskExamService;
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<TaskPageResponseVO>> pageList(@RequestBody TaskPageRequestVO model) {
        PageInfo<TaskExam> pageInfo = taskExamService.page(model);
        PageInfo<TaskPageResponseVO> page = PageInfoHelper.copyMap(pageInfo, m -> {
            TaskPageResponseVO vm = modelMapper.map(m, TaskPageResponseVO.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(m.getCreateTime()));
            return vm;
        });
        return RestResponse.success(page);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RestResponse edit(@RequestBody TaskRequestVO model) {
        taskExamService.edit(model, getCurrentUser());
        TaskRequestVO vm = taskExamService.taskExamToVM(model.getId());
        return RestResponse.success(vm);
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<TaskRequestVO> select(@PathVariable Integer id) {
        TaskRequestVO vm = taskExamService.taskExamToVM(id);
        return RestResponse.success(vm);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public RestResponse delete(@PathVariable Integer id) {
        TaskExam taskExam = taskExamService.selectById(id);
        taskExam.setDeleted(true);
        taskExamService.updateByIdFilter(taskExam);
        return RestResponse.success();
    }
}
