package edu.cl.learn.context;

import edu.cl.learn.domain.User;
import org.springframework.stereotype.Component;

/**
 * @Author: Clay
 * @Date: 2021/2/13 12:36 上午
 */
@Component
public class WebContext {


    public User getCurrentUser() {

        return new User();
    }

}
