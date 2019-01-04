package com.sprintboot.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurerAdapter 自定义拦截器集成WebMvcConfigurerAdapter，SpringBoot 2.0 后，该类被标记为@Deprecated.后的版本中会被取消
 * 解决办法
 * 1、实现WebMvcConfigurer （推荐）
 * 2、集成WebMvcConfigurationSupport
 */
// 该注解表示将类交给spring进行管理
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 可以添加多个拦截器
         */
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new HttpInterceptor1());
    }


    /**
     * 跨域处理
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("====  跨域处理 =====");
        registry.addMapping("/**")
                .allowedMethods("POST");

    }
}
