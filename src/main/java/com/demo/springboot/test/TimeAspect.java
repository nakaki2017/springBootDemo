/**
 * 
 */
package com.demo.springboot.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description 配置 AOP 切面
 * @author lzq
 * @date 2018年4月4日 下午4:50:25
 */
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.light.springboot.controller.FastJsonController..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数为:" + arg);
        }
        long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));
        return object;
    }
}