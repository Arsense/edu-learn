package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.domain.ExamPaper;
import edu.cl.learn.service.ExamPaperService;
import edu.cl.learn.util.DateTimeUtil;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.exam.ExamPaperEditRequestVO;
import edu.cl.learn.vo.exam.ExamPaperPageRequestVO;
import edu.cl.learn.vo.exam.ExamResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:36 下午
 */
@RestController
@Api("试卷管理")
public class ExamPaperController extends BaseApiController {



    @Autowired
    private ExamPaperService examPaperService;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation("分页查询试卷")
    public RestResponse<PageInfo<ExamResponseVO>> pageList(@RequestBody ExamPaperPageRequestVO model) {
        PageInfo<ExamPaper> pageInfo = examPaperService.page(model);
        PageInfo<ExamResponseVO> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamResponseVO vm = modelMapper.map(e, ExamResponseVO.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            return vm;
        });
        return RestResponse.ok(page);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("根据用户名查询")
    public RestResponse<ExamPaperEditRequestVO> edit(@RequestBody  ExamPaperEditRequestVO model) {
        ExamPaper examPaper = examPaperService.savePaperFrom(model, getCurrentUser());
        ExamPaperEditRequestVO newVM = examPaperService.examPaper(examPaper.getId());
        return RestResponse.success(newVM);
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<ExamPaperEditRequestVO> select(@PathVariable Integer id) {
        ExamPaperEditRequestVO vm = examPaperService.examPaperTo(id);
        return RestResponse.success(vm);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public RestResponse delete(@PathVariable Integer id) {
        ExamPaper examPaper = examPaperService.selectById(id);
        examPaper.setDeleted(true);
        examPaperService.updateByIdFilter(examPaper);
        return RestResponse.success(examPaper);
    }

}
