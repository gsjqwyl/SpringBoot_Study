package com.sprintboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 *  @EnableSwagger2: 启用swagger注解
 */
@SpringBootApplication
@EnableSwagger2
public class SprintBootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootStudyApplication.class, args);
	}



}


