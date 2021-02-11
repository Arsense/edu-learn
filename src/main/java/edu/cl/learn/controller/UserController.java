package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.UserService;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.UserPageRequestVO;
import edu.cl.learn.vo.UserResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Clay
 * @Date: 2021/2/11 1:28 上午
 */
@RestController("AdminUserController")
@RequestMapping(value = "/api/admin/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page/list", method = RequestMethod.POST)
    public RestResponse<PageInfo<UserResponseVO>> pageList(@RequestBody UserPageRequestVO model) {
        PageInfo<User> pageInfo = userService.userPage(model);
//        PageInfo<UserResponseVO> page = PageInfoHelper.copyMap(pageInfo, d -> UserResponseVO.from(d));
//        return RestResponse.success("");
        return null;
    }
}
