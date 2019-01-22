package com.sprintboot.Controller;

import com.sprintboot.Mapper.UserMapper1;
import com.sprintboot.Model.User;
import com.sprintboot.aspect.AnnoAspect;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @RestController 相当于@ResponseBody + @Controller
 */
@RestController
@EnableCaching
public class HelloWorldController {

    /**
     * RequestMapping 将Http请求映射到方法上
     * @return
     */
    @RequestMapping("")
    public String HelloWorld(HttpServletRequest request, HttpServletResponse response)
    {
        String name = (String) request.getAttribute("name");
        Integer age = (Integer) request.getAttribute("age");
        //System.out.println(age/0); //报异常
        return "My Name is " + name + "， I'm " + age + " years old.";
    }

    @AnnoAspect(module = "注解测试..")
    @RequestMapping("/aspect")
    public String AspectTest()
    {
        return "Hello";
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

//    @Autowired
//    private UserDao userDao;
//
//    @RequestMapping("/find")
//    public List<User> find() {
//        List<User> list = (List<User>) userDao.findAll();
//        for (User user : list) {
//            System.out.println(user);
//        }
//        return list;
//    }


    @Resource
    private UserMapper1 userMapper1;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * sync:在多线程并发环境下，sync = true 表示将缓存锁住，
     * 每次只能处理一个请求。其他线程堵塞，直到将结果更新至缓存中
     * @return
     */
    @RequestMapping("find_one")
    //@Cacheable(key = "'user' + #user.id")
    public User findOne(User user) {
        logger.info("从数据库中查询....");
        return userMapper1.findById(user.getId());
    }

    /**
     * @CachePut 也声明一个方法支持缓存功能。但是它在执行前不会去检查是否存在缓存，
     * 而是每次将执行结果以键值对的形式存入指定的缓存中。
     * @param user
     * @return
     */
    @RequestMapping("update")
    @CachePut(key = "'user' + #user.id")
    public String update(User user) {
        int count = userMapper1.updateUser(user);
        logger.info("数据更新完毕，更新了：" + count + "条");
        return "success!!!";
    }


    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int count = userMapper1.delete(id);
        if (count > 0) {
            logger.info("删除成功." + count + "条");
            return "success";
        } else {
            logger.info("无该用户..");
            return "None";
        }
    }
}
