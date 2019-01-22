package com.sprintboot.aspect;

import java.lang.annotation.*;

/**
 * @Target 定义注解的作用目标。ElementType.METHOD 作用在方法上
 * @Target(ElementType.TYPE)   //作用在接口、类、枚举、注解
 * @Target(ElementType.FIELD) //作用字段、枚举的常量
 * @Target(ElementType.METHOD) //作用方法
 * @Target(ElementType.PARAMETER) //作用方法参数
 * @Target(ElementType.CONSTRUCTOR)  //作用构造函数
 * @Target(ElementType.LOCAL_VARIABLE)//作用局部变量
 * @Target(ElementType.ANNOTATION_TYPE)//作用注解
 * @Target(ElementType.PACKAGE) ///包
 * @Retention 表明该注解的保留策略 RetentionPolicy.RUNTIME 表示在运行时(通过反射获得)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoAspect {
    String module() default "";
}
