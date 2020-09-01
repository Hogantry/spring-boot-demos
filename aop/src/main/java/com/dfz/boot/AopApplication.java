package com.dfz.boot;

import com.dfz.boot.aop.advisor.ALogAspect;
import com.dfz.boot.aop.service.impl.HelloServiceImpl;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName AopApplication
 * @Description 主要测试切面类的执行顺序
 *              注解或接口 @Priority/PriorityOrder 与 @Order/Order 与未添加任何注解且未实现任何接口的切面类的执行顺序
 *              项目使用AOP功能，只需要依赖spring-boot-starter-aop模块即可，在spring-boot-autoconfigure模块中，会
 *              自动引入AOP相关的配置类，不需要在添加@EnableAspectJAutoProxy注解
 *              @see AopAutoConfiguration
 *
 *              项目使用事务功能，只需要依赖spring-boot-starter-jdbc模块即可，在spring-boot-autoconfigure模块中，会
 *              自动引入事务相关的配置类，不需要在添加@EnableTransactionManagement注解
 *              @see TransactionAutoConfiguration
 *
 *              二次代理问题：
 *
 *                  多级代理通常是不会有问题的，Mybatis的插件机制，即是采用了层层代理的模式。spring中常说的二级代理问题是指，同一个增强，被
 *                  多次织入到目标类中导致的问题，可能会出现循环引用导致应用无法启动。
 *
 *                  在{@link AopConfigUtils}中定义了 APC_PRIORITY_LIST 静态成员变量，并在静态代码块中初始化其值。定义了三个类，分别为
 *                  {@link InfrastructureAdvisorAutoProxyCreator} {@link AspectJAwareAdvisorAutoProxyCreator}
 *                  {@link AnnotationAwareAspectJAutoProxyCreator}，且优先级依次升高，具体可参考
 *                  {@link AopConfigUtils#findPriorityForClass}方法，
 *                  {@link TransactionAutoConfiguration}、@EnableAsync、@EnableCaching
 *                  均会引入{@link InfrastructureAdvisorAutoProxyCreator}，而{@link AopAutoConfiguration}会引入{@link AnnotationAwareAspectJAutoProxyCreator}
 *
 *                  {@link TransactionAutoConfiguration}会向IOC容器中注册关于事务相关的{@link Advisor}，这些{@link Advisor}可以被
 *                  {@link AnnotationAwareAspectJAutoProxyCreator}处理，所以事务是可以生效的。
 *
 *                  {@link AnnotationAwareAspectJAutoProxyCreator}底层是{@link BeanPostProcessor}，实现原理就是先找出IOC容器中
 *                  所有的{@link Advisor}，或者将其处理为{@link Advisor}，然后实例化类时，遍历所有的{@link Advisor}，看是否可以增强需要
 *                  初始化的bean。因此，IOC容器中，如果存在多个{@link AnnotationAwareAspectJAutoProxyCreator}类，或类似处理的类，比如
 *                  {@link DefaultAdvisorAutoProxyCreator}就可能会出现增强已经增强过的类，即二次代理问题的根本原因。因为他们的处理原理大体类似，
 *                  都是从IOC容器中获取增强类，织入到目标对象中。如果存在多个，则可能出现重复织入的问题。
 *
 *                  特别提示：@EnableAsync 注解的实现原理与{@link AnnotationAwareAspectJAutoProxyCreator}不同，他引入的{@link AsyncAnnotationBeanPostProcessor}
 *                          类，也是{@link BeanPostProcessor}子类，但是他不是从IOC容器中找{@link Advisor}，而是在定义时就初始化了属于自己的{@link Advisor}，(内部属性)
 *                          所以可能会出现继续代理了代理类，但是不会出现重复增强的情况。
 *
 *                          而@EnableCaching的实现原理则与事务{@link TransactionAutoConfiguration}的实现原理类似，尝试注册
 *                          {@link InfrastructureAdvisorAutoProxyCreator}，但不会成功，然后会注册缓存相关{@link Advisor}进IOC容器，
 *                          并会被AOP的{@link AnnotationAwareAspectJAutoProxyCreator}发现被织入到相应bean中完成增强。
 * @Author dfz
 * @Date 2019-11-13 10:17
 * @Version 1.0
 **/
@SpringBootApplication
@EnableAsync
@EnableCaching
//@EnableAspectJAutoProxy
//@EnableTransactionManagement
public class AopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
        String property = context.getEnvironment().getProperty("spring.aop.proxy-target-class");
        System.out.println(property);

        ALogAspect aLogAspect = context.getBean(ALogAspect.class);
        System.out.println(aLogAspect);

        HelloServiceImpl helloService = context.getBean(HelloServiceImpl.class);
        System.out.println(helloService);
        helloService.sayHello("dfc");

        AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        HelloServiceImpl helloService2 = beanFactory.getBean(HelloServiceImpl.class);
        System.out.println(helloService2);

        Object bean = context.getBean(AopConfigUtils.AUTO_PROXY_CREATOR_BEAN_NAME);
        System.out.println(bean + " " + bean.getClass());

    }

}
