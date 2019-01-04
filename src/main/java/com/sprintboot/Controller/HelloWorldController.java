package com.sprintboot.Controller;

import com.sprintboot.Dao.UserDao;
import com.sprintboot.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


/**
 * @RestController 相当于@ResponseBody + @Controller
 */
@RestController
public class HelloWorldController {

    /**
     * RequestMapping 将Http请求映射到方法上
     * @return
     */
    @RequestMapping("/")
    public String HelloWorld() {
        return "Hello World";
    }

    @RequestMapping("/json")
    public User getUser() {
        User user = new User();
        user.setId("1231231");
        user.setAge(18);
        user.setUserName("wyl");
        System.out.print("我要return了....");
        return user;
    }

    @Autowired
    private UserDao userDao;

    @RequestMapping("/find")
    public List<User> find() {
        List<User> list = (List<User>) userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }
}
