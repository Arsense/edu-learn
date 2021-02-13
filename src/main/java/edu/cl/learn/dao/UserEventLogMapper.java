package edu.cl.learn.dao;

import edu.cl.learn.domain.KeyValue;
import edu.cl.learn.domain.UserEventLog;
import edu.cl.learn.vo.log.UserEventPageRequestVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserEventLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserEventLog record);

    int insertSelective(UserEventLog record);

    UserEventLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEventLog record);

    int updateByPrimaryKey(UserEventLog record);

    List<UserEventLog> getUserEventLogByUserId(Integer id);

    List<UserEventLog> page(UserEventPageRequestVO requestVO);

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
