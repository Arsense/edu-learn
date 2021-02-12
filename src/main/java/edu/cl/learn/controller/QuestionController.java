package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.base.SystemCode;
import edu.cl.learn.domain.Question;
import edu.cl.learn.service.QuestionService;
import edu.cl.learn.util.DateTimeUtil;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.question.QuestionEditRequestVO;
import edu.cl.learn.vo.question.QuestionPageRequestVO;
import edu.cl.learn.vo.question.QuestionResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:49 下午
 */
@RequestMapping(value = "/api/admin/question")
@Api(tags = "题目管理")
public class QuestionController extends BaseApiController {


    @Autowired
    private QuestionService questionService;
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation("分页查询题目")
    public RestResponse<PageInfo<QuestionResponseVO>> pageList(@RequestBody QuestionPageRequestVO model) {
        PageInfo<Question> pageInfo = questionService.page(model);
        PageInfo<QuestionResponseVO> page = PageInfoHelper.copyMap(pageInfo, q -> {
            QuestionResponseVO vm = modelMapper.map(q, QuestionResponseVO.class);
//            vm.setCreateTime(DateTimeUtil.dateFormat(q.getCreateTime()));
//            vm.setScore(ExamUtil.scoreToVM(q.getScore()));
//            TextContent textContent = textContentService.selectById(q.getInfoTextContentId());
//            QuestionObject questionObject = JsonUtil.toJsonObject(textContent.getContent(), QuestionObject.class);
//            String clearHtml = HtmlUtil.clear(questionObject.getTitleContent());
//            vm.setShortTitle(clearHtml);
            return vm;
        });
        return RestResponse.success(page);
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    @ApiOperation("根据id查询题目")
    public RestResponse<QuestionEditRequestVO> select(@PathVariable Integer id) {
        QuestionEditRequestVO newVM = questionService.getQuestionEditRequestVO(id);
        return RestResponse.success(newVM);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiOperation("删除题目")
    public RestResponse delete(@PathVariable Integer id) {
        Question question = questionService.selectById(id);
        question.setDeleted(true);
        questionService.updateByIdFilter(question);
        return RestResponse.success();
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("编辑插入题目")
    public RestResponse edit(@RequestBody  QuestionEditRequestVO model) {
        RestResponse validQuestionEditRequestResult = validQuestionEditRequestVO(model);
        if (validQuestionEditRequestResult.getCode() != SystemCode.SUCCESS.getCode()) {
            return validQuestionEditRequestResult;
        }

        if (null == model.getId()) {
            questionService.insertFullQuestion(model, getCurrentUser().getId());
        } else {
            questionService.updateFullQuestion(model);
        }

        return RestResponse.success();
    }

    private RestResponse validQuestionEditRequestVO(QuestionEditRequestVO model) {
            return null;
    }
}
