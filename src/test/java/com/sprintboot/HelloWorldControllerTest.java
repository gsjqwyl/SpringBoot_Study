package com.sprintboot;

import com.sprintboot.Controller.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * HelloWorld 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTest {

    /**
     * MockMvc 实现了对HTTP请求的模拟, 能够直接使用网络的形式，转换到Controller的调用
     */
    private MockMvc mvc;

    @Before
    public void setup() throws Exception {

        /**
         * 通过参数指定一组控制器
         */
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void hello_test() throws Exception {
        /**
         * mvc.perform 执行一个请求
         * MockMvcRequestBuilders.get("/") 构造一个请求
         * accept(MediaType.APPLICATION_JSON) 添加application/json的响应头
         * andExpect 添加执行完成之后的断言
         * andDO 添加一个结果处理器，表示要对结果做点什么事情
         * MockMvcResultHandlers.print() 输出整个响应的结果信息
         * andReturn 表示执行完成后要Return什么结果
         */
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
