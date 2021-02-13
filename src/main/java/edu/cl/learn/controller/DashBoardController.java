package edu.cl.learn.controller;

import com.alibaba.fastjson.JSON;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.vo.IndexVO;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Clay
 * @Date: 2021/2/12 2:00 上午
 */
@Controller
@Api(tags = "首页管理")
@RequestMapping(value = "/api/admin/dashboard")
public class DashBoardController extends BaseApiController {

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public RestResponse<IndexVO> Index() {

        String json = "{\n" +
                "\t\"code\": 1,\n" +
                "\t\"message\": \"成功\",\n" +
                "\t\"response\": {\n" +
                "\t\t\"examPaperCount\": 967,\n" +
                "\t\t\"questionCount\": 396,\n" +
                "\t\t\"doExamPaperCount\": 3118,\n" +
                "\t\t\"doQuestionCount\": 12834,\n" +
                "\t\t\"mothDayUserActionValue\": [203, 269, 184, 174, 172, 81, 134, 124, 162, 84, 36, 52, 12],\n" +
                "\t\t\"mothDayDoExamQuestionValue\": [106, 121, 56, 23, 85, 18, 35, 26, 39, 21, 14, 10, 0],\n" +
                "\t\t\"mothDayText\": [\"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"11\", \"12\", \"13\", \"14\", \"15\", \"16\", \"17\", \"18\", \"19\", \"20\", \"21\", \"22\", \"23\", \"24\", \"25\", \"26\", \"27\", \"28\"]\n" +
                "\t}\n" +
                "}";
        RestResponse<IndexVO> restResponse = JSON.parseObject(json, RestResponse.class);
        System.out.println("结果是" + JSON.toJSONString(restResponse));
        return restResponse;

    }
}
