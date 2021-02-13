package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.domain.KeyValue;
import edu.cl.learn.domain.User;
import edu.cl.learn.domain.UserEventLog;
import edu.cl.learn.service.AuthenticationService;
import edu.cl.learn.service.UserEventLogService;
import edu.cl.learn.service.UserService;
import edu.cl.learn.util.DateTimeUtil;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.log.UserEventLogVO;
import edu.cl.learn.vo.log.UserEventPageRequestVO;
import edu.cl.learn.vo.user.UserCreateVO;
import edu.cl.learn.vo.user.UserPageRequestVO;
import edu.cl.learn.vo.user.UserResponseVO;
import edu.cl.learn.vo.user.UserUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

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

    @Autowired
    private UserEventLogService userEventLogService;
    @Autowired
    private  AuthenticationService authenticationService;


    @PostMapping("/page/list")
    @ApiOperation("用户信息分页查询")
    public RestResponse<PageInfo<UserResponseVO>> pageList(@RequestBody UserPageRequestVO model) {
        PageInfo<User> pageInfo = userService.userPage(model);
        System.out.println("执行一次");
        if (pageInfo != null) {
            PageInfo<UserResponseVO> page = PageInfoHelper.copyMap(pageInfo, data -> UserResponseVO.from(data));
            return RestResponse.success(page);
        }

        return RestResponse.success();

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("")
    public RestResponse<User> edit(@RequestBody  UserCreateVO model) {
        if (model.getId() == null) {
            //create
            User existUser = userService.getUserByUserName(model.getUserName());
            if (null != existUser) {
                return new RestResponse<>(2, "用户已存在");
            }

            if (StringUtils.isBlank(model.getPassword())) {
                return new RestResponse<>(3, "密码不能为空");
            }
        }

        User user = modelMapper.map(model, User.class);

        if (model.getId() == null) {
            String encodePwd = authenticationService.encode(model.getPassword());
            user.setPassword(encodePwd);
            user.setUserUuid(UUID.randomUUID().toString());
            user.setCreateTime(new Date());
            user.setLastActiveTime(new Date());
            user.setDeleted(false);
            userService.insertByFilter(user);
        } else {
            if (!StringUtils.isBlank(model.getPassword())) {
                String encodePwd = authenticationService.encode(model.getPassword());
                user.setPassword(encodePwd);
            }
            user.setModifyTime(new Date());
            userService.updateByIdFilter(user);
        }
        return RestResponse.success(user);



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
        return RestResponse.success(user);
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
    public RestResponse<PageInfo<UserEventLogVO>> eventPageList(@RequestBody UserEventPageRequestVO model) {
        PageInfo<UserEventLog> pageInfo = userEventLogService.page(model);
        PageInfo<UserEventLogVO> page = PageInfoHelper.copyMap(pageInfo, d -> {
            UserEventLogVO vm = modelMapper.map(d, UserEventLogVO.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(d.getCreateTime()));
            return vm;
        });
        return RestResponse.success(page);
    }

}
