package com.dfz.boot.aop.advisor;

import com.dfz.boot.aop.BlogProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @ClassName ALogAspect
 * @Description 切面优先级与使用注解@Priority/@Order或实现接口PriorityOrder/Order有关，且注解值或接口的返回值越小，优先级越高
 *
 *              切面类中尽量不要引入其他bean，可能会有问题，如下注入属性值，测试是没有问题的。如果是注入其他的普通bean，会导致该bean
 *              提前实例化，后续如果存在对该bean的一些处理，比如代理，都不会再生效了。
 * @Author dfz
 * @Date 2019-09-12 09:33
 * @Version 1.0
 **/
@Aspect
@Component
@Priority(-20)
//@Order(-2)
public class ALogAspect {

    @Autowired
    BlogProperties blogProperties;

    @Pointcut("@annotation(com.dfz.boot.aop.annotation.Dfz)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("A-------- before");
        Object proceed = joinPoint.proceed();
        System.out.println("A--------after");
        return proceed;
    }

    @Override
    public String toString() {
        return "ALogAspect{" +
                "blogProperties=" + blogProperties +
                '}';
    }
}
