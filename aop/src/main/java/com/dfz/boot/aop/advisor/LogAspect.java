package com.dfz.boot.aop.advisor;

import com.dfz.boot.aop.BlogProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAspect
 * @Description LogAspect
 * @Author dfz
 * @Date 2019-09-10 09:39
 * @Version 1.0
 **/
@Aspect
@Component
public class LogAspect {

//    @Autowired
//    BlogProperties blogProperties;

    @Pointcut("@annotation(com.dfz.boot.aop.annotation.Dfz)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("1--------1");
        Object proceed = joinPoint.proceed();
        System.out.println("1--------2");
        return proceed;
    }

}
