package com.dfz.boot.aop.advisor;

import com.dfz.boot.aop.BlogProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName ALogAspect
 * @Description ALogAspect
 * @Author dfz
 * @Date 2019-09-12 09:33
 * @Version 1.0
 **/
@Aspect
//@Component
//@Priority(0)
@Order(-2)
public class ALogAspect {

    @Autowired
    BlogProperties blogProperties;

    @Pointcut("@annotation(com.dfz.boot.aop.annotation.Dfz)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("a--------1");
        Object proceed = joinPoint.proceed();
        System.out.println("a--------2");
        return proceed;
    }

}
