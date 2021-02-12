package edu.cl.learn.service.impl;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.UserEventLog;
import edu.cl.learn.service.UserEventLogService;
import edu.cl.learn.vo.log.UserEventPageRequestVO;
import org.springframework.stereotype.Service;

/**
 * @Author: Clay
 * @Date: 2021/2/13 1:03 上午
 */
@Service
public class UserEventLogServiceImpl implements UserEventLogService {
    @Override
    public PageInfo<UserEventLog> page(UserEventPageRequestVO model) {
        return null;
    }
}
