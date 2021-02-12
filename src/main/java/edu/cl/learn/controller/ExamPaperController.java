package edu.cl.learn.controller;

import edu.cl.learn.base.RestResponse;
import edu.cl.learn.util.DateTimeUtil;
import edu.cl.learn.util.PageInfoHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:36 下午
 */
@RestController
@Api("试卷管理")
public class ExamPaperController {


    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation("分页查询试卷")
    public RestResponse<PageInfo<ExamResponseVM>> pageList(@RequestBody ExamPaperPageRequestVM model) {
        PageInfo<ExamPaper> pageInfo = examPaperService.page(model);
        PageInfo<ExamResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamResponseVM vm = modelMapper.map(e, ExamResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            return vm;
        });
        return RestResponse.ok(page);
    }

}
