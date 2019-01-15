package com.sprintboot.IDao;


import com.sprintboot.domain.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 需要在这加上Mapper ，不然
 */
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}