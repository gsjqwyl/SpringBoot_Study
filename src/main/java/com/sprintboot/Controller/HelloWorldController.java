package com.sprintboot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
