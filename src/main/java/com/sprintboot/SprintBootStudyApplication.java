package com.sprintboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;

import java.util.Arrays;

@SpringBootApplication
// @MapperScan(basePackages = {"com.sprintboot.IDao"})
public class SprintBootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootStudyApplication.class, args);
	}



}


