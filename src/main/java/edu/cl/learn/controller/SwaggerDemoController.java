package edu.cl.learn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Clay
 * @Date: 2021/2/10 11:42 下午
 */
@Controller
@Api(tags = "测试管理")
public class SwaggerDemoController {



    @ApiOperation("基本样例测试")
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    @ResponseBody
    public String demo() {
        return "测试成功";
    }



    @ApiOperation("基本样例测试")
    @RequestMapping(value = "/request", method = RequestMethod.GET)
    @ResponseBody
    public String demoRequest() {
        return "测试成功";
    }



}
