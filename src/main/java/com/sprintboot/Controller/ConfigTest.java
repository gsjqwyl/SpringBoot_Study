package com.sprintboot.Controller;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ConfigTest {

    public ConfigTest() {
        System.out.println("===== >> @Configuration ConfigTest容器初始化中...");
    }

    @Bean
    public void BeanTest() {
        //System.out.println("注解Bean 已添加组件");
    }
}
