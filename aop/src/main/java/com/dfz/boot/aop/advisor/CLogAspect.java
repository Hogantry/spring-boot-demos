package com.dfz.boot.aop.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @ClassName LogAspect
 * @Description LogAspect
 * @Author dfz
 * @Date 2019-09-10 09:39
 * @Version 1.0
 **/
@Aspect
@Component
//@Order(0)
@Priority(-1)
public class CLogAspect {

    @Pointcut("@annotation(com.dfz.boot.aop.annotation.Dfz)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("C-------- before");
        Object proceed = joinPoint.proceed();
        System.out.println("C--------after");
        return proceed;
    }

}
