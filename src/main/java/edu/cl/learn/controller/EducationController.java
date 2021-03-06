package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.domain.Subject;
import edu.cl.learn.service.SubjectService;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.subject.SubjectEditRequestVO;
import edu.cl.learn.vo.subject.SubjectPageRequestVO;
import edu.cl.learn.vo.subject.SubjectResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: Clay
 * @Date: 2021/2/12 1:59 上午
 */
@Controller
@Api(tags = "学科管理")
@RequestMapping(value = "/api/admin/education")
public class EducationController extends BaseApiController {


    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/subject/list", method = RequestMethod.POST)
    @ApiOperation("获取全部的学科信息")
    public RestResponse<List<Subject>> list() {
        List<Subject> subjects = subjectService.allSubject();
        return RestResponse.success(subjects);
    }

    @RequestMapping(value = "/subject/page", method = RequestMethod.POST)
    @ApiOperation("分页查询学科")
    public RestResponse<PageInfo<SubjectResponseVO>> pageList(@RequestBody SubjectPageRequestVO model) {
        PageInfo<Subject> pageInfo = subjectService.page(model);
        PageInfo<SubjectResponseVO> page = PageInfoHelper.copyMap(pageInfo, e -> modelMapper.map(e, SubjectResponseVO.class));
        return RestResponse.success(page);
    }


    @RequestMapping(value = "/subject/edit", method = RequestMethod.POST)
    @ApiOperation("添加与编辑学科")
    public RestResponse edit(@RequestBody  SubjectEditRequestVO model) {
        Subject subject = modelMapper.map(model, Subject.class);
        if (model.getId() == null) {
            subject.setDeleted(false);
            subjectService.insertByFilter(subject);
        } else {
            subjectService.updateByIdFilter(subject);
        }
        return RestResponse.success(subject);
    }

    @RequestMapping(value = "/subject/select/{id}", method = RequestMethod.POST)
    @ApiOperation("根据id查询")
    public RestResponse<SubjectEditRequestVO> select(@PathVariable Integer id) {
        Subject subject = subjectService.selectById(id);
        SubjectEditRequestVO vm = modelMapper.map(subject, SubjectEditRequestVO.class);
        return RestResponse.success(vm);
    }

    @RequestMapping(value = "/subject/delete/{id}", method = RequestMethod.POST)
    @ApiOperation("根据id删除")
    public RestResponse delete(@PathVariable Integer id) {
        Subject subject = subjectService.selectById(id);
        subject.setDeleted(true);
        subjectService.updateByIdFilter(subject);
        return RestResponse.success();
    }




}
