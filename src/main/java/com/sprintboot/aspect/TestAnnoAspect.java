package com.sprintboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TestAnnoAspect {

    @Pointcut("@annotation(com.sprintboot.aspect.AnnoAspect)")
    public void aspectPointCut() {
    }

    @Before("aspectPointCut()")
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature)point.getSignature();
        AnnoAspect annoAspect = signature.getMethod().getAnnotation(AnnoAspect.class);
        System.out.println("前处理Beginning..., 注解value为=== >" + annoAspect.module());
    }

    @After("aspectPointCut()")
    public void after(JoinPoint point) {
        System.out.println("后处理Ending...");
    }


}
