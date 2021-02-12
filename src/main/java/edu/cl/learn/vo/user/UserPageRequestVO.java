package edu.cl.learn.vo.user;

import edu.cl.learn.base.BasePage;
import lombok.Data;

/**
 * @Author: Clay
 * @Date: 2021/2/12 1:51 上午
 */
@Data
public class UserPageRequestVO extends BasePage {

    private String userName;
    private Integer role;

}
