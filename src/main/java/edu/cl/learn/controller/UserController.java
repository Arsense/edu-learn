package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.UserService;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.UserPageRequestVO;
import edu.cl.learn.vo.UserResponseVO;
import edu.cl.learn.vo.UserUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

/**
 * @Author: Clay
 * @Date: 2021/2/11 1:28 上午
 */
@RestController("AdminUserController")
@RequestMapping(value = "/api/admin/user")
@Api(tags = "用户管理")
public class UserController extends BaseApiController {

    @Autowired
    private UserService userService;


    @PostMapping("/page/list")
    @ApiOperation("用户信息分页查询")
    public RestResponse<PageInfo<UserResponseVO>> pageList(@RequestBody UserPageRequestVO model) {
        PageInfo<User> pageInfo = userService.userPage(model);
        PageInfo<UserResponseVO> page = PageInfoHelper.copyMap(pageInfo, data -> UserResponseVO.from(data));
        return RestResponse.success(page);
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    @ApiOperation("用户信息单个查询")
    public RestResponse<UserResponseVO> select(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        UserResponseVO userVm = UserResponseVO.from(user);
        return RestResponse.success(userVm);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("用户信息更新")
    public RestResponse update(@RequestBody UserUpdateVO model) {
        User user = userService.selectById(getCurrentUser().getId());
        modelMapper.map(model, user);
        user.setModifyTime(new Date());
        userService.updateByIdFilter(user);
        return RestResponse.success();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiOperation("删除用户")
    public RestResponse delete(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        user.setDeleted(true);
        userService.updateByIdFilter(user);
        return RestResponse.success();
    }




    @RequestMapping(value = "/selectByUserName", method = RequestMethod.POST)
    @ApiOperation("根据用户名查询")
    public RestResponse<List<KeyValue>> selectByUserName(@RequestBody String userName) {
        List<KeyValue> keyValues = userService.selectByUserName(userName);
        return RestResponse.success(keyValues);
    }


    @RequestMapping(value = "/event/page/list", method = RequestMethod.POST)
    @ApiOperation("用户操作日志查询")
    public RestResponse<PageInfo<UserEventLogVM>> eventPageList(@RequestBody UserEventPageRequestVM model) {
        PageInfo<UserEventLog> pageInfo = userEventLogService.page(model);
        PageInfo<UserEventLogVM> page = PageInfoHelper.copyMap(pageInfo, d -> {
            UserEventLogVM vm = modelMapper.map(d, UserEventLogVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(d.getCreateTime()));
            return vm;
        });
        return RestResponse.success(page);
    }

}
