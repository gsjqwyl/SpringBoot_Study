package com.sprintboot.Controller;

import com.sprintboot.IDao.UserMapper;
import com.sprintboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DataBaseXmlController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/xmluser")
    public String user() {
        User user = new User();
        user.setId(10001);
        user.setMobile("18829999999");
        user.setAge(22);
        user.setName("JavaMan");
        userMapper.insert(user);
        return "success";
    }
}
