package com.sprintboot.Mapper;

import com.sprintboot.Model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MyBatis通过注解的方式进行数据库操作主要提供了CRUD(@Select，@Insert, @Update, @Delete)注解
 */
@Mapper
public interface UserMapper1 extends Mapper{

    //插入
    @Insert("insert into user(name, mobile, age) values (#{userName}, #{mobile}, #{age})")
    int insert(User user);


    /**
     * 通过Select 注解直接通过SQL进行数据库操作
     * 通过Result注解完成单个字段的 实体类和数据库字段的映射
     * Results多个字段的映射关系
     * 实体类中姓名字段和数据库字段不一样，因此需要做映射，否则会返回null
     */
    //查询
    @Results(value = {
            @Result(property = "userName", column = "name", jdbcType = JdbcType.VARCHAR)
    })
    @Select("select * from user")
    List<User> getAll();

    //更新
    @Update("update user set userName = #{userName} where id = #{id}")
    int updateUser(User user);

    @Results(value = {
            @Result(property = "userName", column = "name", jdbcType = JdbcType.VARCHAR)
    })
    @Select("select * from user where id = #{id}")
    User findById(String id);

    //删除
    @Delete("delete from user where id = #{id}")
    int delete(Integer id);
}
