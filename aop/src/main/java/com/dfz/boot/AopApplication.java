package com.dfz.boot;

import com.dfz.boot.aop.service.HelloService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName AopApplication
 * @Description 主要测试切面类的执行顺序
 *              @Priority/PriorityOrder 与 @Order/Order 与未添加任何注解且未实现任何接口的切面类的执行顺序
 *              项目使用AOP功能，只需要依赖spring-boot-starter-aop模块即可，在spring-boot-autoconfigure模块中，会
 *              自动引入AOP相关的配置类，不需要在添加@EnableAspectJAutoProxy注解
 * @Author dfz
 * @Date 2019-11-13 10:17
 * @Version 1.0
 **/
@SpringBootApplication
//@EnableAspectJAutoProxy
//@EnableTransactionManagement
public class AopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
//        String property = context.getEnvironment().getProperty("spring.aop.proxy-target-class");
//        System.out.println(property);
//        HelloService helloService = context.getBean(HelloService.class);
//        System.out.println(helloService);
//        helloService.sayHello();

//        AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
//        HelloService helloService2 = beanFactory.getBean(HelloService.class);
//        System.out.println(helloService2);

    }

}
