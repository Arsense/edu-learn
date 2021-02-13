package edu.cl.learn.dao;

import edu.cl.learn.domain.KeyValue;
import edu.cl.learn.domain.User;
import edu.cl.learn.vo.user.UserPageRequestVO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户查询Mapper
 * @Author: Clay
 * @Date: 2021/2/12 1:58 上午
 */
@Mapper
public interface UserMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    /**
     * getAllUser
     *
     * @return List<User>
     */
    List<User> getAllUser();

    /**
     * getUserById
     *
     * @param id id
     * @return User
     */
    User getUserById(Integer id);

    /**
     * getUserByUserName
     *
     * @param username username
     * @return User
     */
    User getUserByUserName(String username);

    /**
     * getUserByUserNamePwd
     *
     * @param username username
     * @param pwd      pwd
     * @return User
     */
    User getUserByUserNamePwd(@Param("username") String username, @Param("pwd") String pwd);

    /**
     * getUserByUuid
     *
     * @param uuid uuid
     * @return User
     */
    User getUserByUuid(String uuid);

    /**
     * userPageList
     *
     * @param map userPageList
     * @return List<User>
     */
    List<User> userPageList(Map<String, Object> map);


    /**
     * userPageCount
     *
     * @param map map
     * @return Integer
     */
    Integer userPageCount(Map<String, Object> map);


    /**
     * @param request request
     * @return List<User>
     */
    List<User> userPage(UserPageRequestVO request);


    /**
     * insertUser
     *
     * @param user user
     */
    void insertUser(User user);

    /**
     * insertUsers
     *
     * @param users users
     */
    void insertUsers(List<User> users);

    /**
     * updateUser
     *
     * @param user user
     */
    void updateUser(User user);

    /**
     * updateUsersAge
     *
     * @param map map
     */
    void updateUsersAge(Map<String, Object> map);

    /**
     * deleteUsersByIds
     *
     * @param ids ids
     */
    void deleteUsersByIds(List<Integer> ids);

    /**
     * insertUserSql
     *
     * @param user user
     */
    void insertUserSql(User user);

    Integer selectAllCount();

    List<KeyValue> selectByUserName(String userName);

    List<User> selectByIds(List<Integer> ids);


    User selectByWxxOpenId(@Param("wxOpenId") String wxOpenId);

}
