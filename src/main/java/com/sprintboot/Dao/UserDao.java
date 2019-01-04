package com.sprintboot.Dao;


import com.sprintboot.Model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *  UserDao接口 集成CrudRepository
 *  CrudRepository需要传两个类，User: 数据库要操作的实体类
 *  Integer:: User中id对应的类型
 */
public interface UserDao extends CrudRepository<User, String> {
}
