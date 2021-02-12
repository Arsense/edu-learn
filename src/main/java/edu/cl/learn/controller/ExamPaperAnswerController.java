package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.domain.ExamPaperAnswer;
import edu.cl.learn.domain.Subject;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.ExamPaperAnswerService;
import edu.cl.learn.service.SubjectService;
import edu.cl.learn.util.DateTimeUtil;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.answer.ExamPaperAnswerPageRequestVO;
import edu.cl.learn.vo.answer.ExamPaperAnswerPageResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Clay
 * @Date: 2021/2/12 4:58 下午
 */
@Controller
@Api(tags = "试卷批改管理")
public class ExamPaperAnswerController extends BaseApiController {

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;


    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation("试卷批改查询")
    public RestResponse<PageInfo<ExamPaperAnswerPageResponseVO>> pageJudgeList(@RequestBody ExamPaperAnswerPageRequestVO model) {
        PageInfo<ExamPaperAnswer> pageInfo = examPaperAnswerService.adminPage(model);
        PageInfo<ExamPaperAnswerPageResponseVO> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamPaperAnswerPageResponseVO vm = modelMapper.map(e, ExamPaperAnswerPageResponseVO.class);
            Subject subject = subjectService.selectById(vm.getSubjectId());
            vm.setDoTime(ExamUtil.secondToVM(e.getDoTime()));
            vm.setSystemScore(ExamUtil.scoreToVM(e.getSystemScore()));
            vm.setUserScore(ExamUtil.scoreToVM(e.getUserScore()));
            vm.setPaperScore(ExamUtil.scoreToVM(e.getPaperScore()));
            vm.setSubjectName(subject.getName());
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            User user = userService.selectById(e.getCreateUser());
            vm.setUserName(user.getUserName());
            return vm;
        });
        return RestResponse.success(page);
    }



}
