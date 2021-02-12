package edu.cl.learn.vo;

import edu.cl.learn.domain.User;
import edu.cl.learn.util.DateTimeUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Author: Clay
 * @Date: 2021/2/12 1:47 上午
 */
@Data
public class UserResponseVO {

    private Integer id;

    private String userUuid;

    private String userName;

    private String realName;

    private Integer age;

    private Integer role;

    private Integer sex;

    private String birthDay;

    private String phone;

    private String lastActiveTime;

    private String createTime;

    private String modifyTime;

    private Integer status;

    private Integer userLevel;

    private String imagePath;

    public static UserResponseVO from(User user) {
        UserResponseVO userResponseVO = new UserResponseVO();
        BeanUtils.copyProperties(user, userResponseVO);
        userResponseVO.setBirthDay(DateTimeUtil.dateFormat(user.getBirthDay()));
        userResponseVO.setLastActiveTime(DateTimeUtil.dateFormat(user.getLastActiveTime()));
        userResponseVO.setCreateTime(DateTimeUtil.dateFormat(user.getCreateTime()));
        userResponseVO.setModifyTime(DateTimeUtil.dateFormat(user.getModifyTime()));
        return userResponseVO;
    }
}
