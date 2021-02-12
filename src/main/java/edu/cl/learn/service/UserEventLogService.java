package edu.cl.learn.service;

import com.github.pagehelper.PageInfo;
import edu.cl.learn.domain.UserEventLog;
import edu.cl.learn.vo.log.UserEventPageRequestVO;

/**
 * @Author: Clay
 * @Date: 2021/2/13 1:03 上午
 */
public interface UserEventLogService {
    PageInfo<UserEventLog> page(UserEventPageRequestVO model);
}
