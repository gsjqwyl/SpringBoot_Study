package com.sprintboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Aspect: 标识这是个切面类
 * @Component  将切面类 实例化到Spring容器中
 */
@Aspect
@Component
public class WebAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *  声明一个切点，是为了告诉切面，谁是它的服务对象。
     */
    // @Pointcut("execution(* *(..))") //表示匹配所有方法
    @Pointcut("execution(public * com.sprintboot.Controller.HelloWorldController.* (..))") //匹配指定类的 public方法
    public void aspectTest() {
    }


    /**
     * 除了@Around之外，如果用不到JoinPoint，方法里可以不加参数JoinPoint。
     * JoinPoint里包含了类名，切面的方法名，参数等属性。
     */

    /**
     * 前处理，方法执行开始前执行
     */
    @Before("aspectTest()")
    public void before(JoinPoint point) {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> parameter = request.getParameterNames();
        while (parameter.hasMoreElements()) {
            String name = (String) parameter.nextElement();
            String v = (String) request.getParameter(name);
            logger.info("key: {}, value: {}", name, v);
        }
        System.out.println("URL:" + request.getRequestURL().toString() + "METHOD:" + request.getMethod() + "，Begin = " + System.currentTimeMillis());
    }

    /**
     * 后处理，方法执行完毕返回的内容, 不管程序是否异常都会执行。
     */
    @After("aspectTest()")
    public void after(JoinPoint point) {
        System.out.println("After End = " + System.currentTimeMillis());
    }

    /**
     * 方法正常执行完毕 才会执行。
     */
    @AfterReturning("aspectTest()")
    public void afterRunning() {
        System.out.println("afterRunning .....");
    }

    /**
     * 程序出现异常，执行
     */
    @AfterThrowing("aspectTest()")
    public void runThrow(JoinPoint point) {
        System.out.println("阿欧, 出现异常了...");
    }

//    @Around("aspectTest()")
//    public void around(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("方法环绕 Begin....");
//        // 允许方法执行
//        point.proceed();
//        System.out.println("方法环绕 Ending....");
//    }

}
