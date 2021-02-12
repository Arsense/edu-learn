package edu.cl.learn.controller;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.base.RestResponse;
import edu.cl.learn.domain.Message;
import edu.cl.learn.domain.MessageUser;
import edu.cl.learn.domain.User;
import edu.cl.learn.service.MessageService;
import edu.cl.learn.service.UserService;
import edu.cl.learn.util.DateTimeUtil;
import edu.cl.learn.util.PageInfoHelper;
import edu.cl.learn.vo.message.MessagePageRequestVO;
import edu.cl.learn.vo.message.MessageResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Clay
 * @Date: 2021/2/12 5:00 下午
 */
@Controller
@RequestMapping(value = "/api/admin/message")
@ApiOperation("消息列表管理")
public class MessageController extends BaseApiController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/page", method = RequestMethod.POST)
//    public RestResponse<PageInfo<MessageResponseVO>> pageList(@RequestBody MessagePageRequestVO model) {
//        PageInfo<Message> pageInfo = messageService.page(model);
//        List<Integer> ids = pageInfo.getList().stream().map(d -> d.getId()).collect(Collectors.toList());
//        List<MessageUser> messageUsers = ids.size() == 0 ? null : messageService.selectByMessageIds(ids);
//        PageInfo<MessageResponseVO> page = PageInfoHelper.copyMap(pageInfo, m -> {
//            MessageResponseVO vm = modelMapper.map(m, MessageResponseVO.class);
//            String receives = messageUsers.stream().filter(d -> d.getMessageId().equals(m.getId())).map(d -> d.getReceiveUserName())
//                    .collect(Collectors.joining(","));
//            vm.setReceives(receives);
//            vm.setCreateTime(DateTimeUtil.dateFormat(m.getCreateTime()));
//            return vm;
//        });
//        return RestResponse.ok(page);
//    }
//
//
//    @RequestMapping(value = "/send", method = RequestMethod.POST)
//    public RestResponse send(@RequestBody @Valid MessageSendVO model) {
//        User user = getCurrentUser();
//        List<User> receiveUser = userService.selectByIds(model.getReceiveUserIds());
//        Date now = new Date();
//        Message message = new Message();
//        message.setTitle(model.getTitle());
//        message.setContent(model.getContent());
//        message.setCreateTime(now);
//        message.setReadCount(0);
//        message.setReceiveUserCount(receiveUser.size());
//        message.setSendUserId(user.getId());
//        message.setSendUserName(user.getUserName());
//        message.setSendRealName(user.getRealName());
//        List<MessageUser> messageUsers = receiveUser.stream().map(d -> {
//            MessageUser messageUser = new MessageUser();
//            messageUser.setCreateTime(now);
//            messageUser.setReaded(false);
//            messageUser.setReceiveRealName(d.getRealName());
//            messageUser.setReceiveUserId(d.getId());
//            messageUser.setReceiveUserName(d.getUserName());
//            return messageUser;
//        }).collect(Collectors.toList());
//        messageService.sendMessage(message, messageUsers);
//        return RestResponse.ok();
//    }
}
