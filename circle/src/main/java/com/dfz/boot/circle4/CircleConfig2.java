package com.dfz.boot.circle4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version V1.0
 * @author: DFZ
 * @description: 如果存在循环依赖，则在自定义BeanPostProcessor生成代理时，一定要使用SmartInstantiationAwareBeanPostProcessor接口，并
 *               在getEarlyBeanReference方法中返回代理类，否则spring会无法解决循环依赖的问题。
 * @date: 2021/3/25 14:17
 * @Copyright: 2021 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Configuration
@ComponentScan("com.dfz.boot.circle4")
public class CircleConfig2 {

    @Configuration
    public static class PostProcessorA {

        @Bean
        public BeanPostProcessor postProcessorA() {
            return new BeanPostProcessor() {
                @Override
                public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                    if (beanName.equalsIgnoreCase("BeanA")) {
                        return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                                bean.getClass().getInterfaces(), new InvocationHandler() {
                                    @Override
                                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                        return null;
                                    }
                                });
                    }
                    return bean;
                }

                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    return bean;
                }
            };
        }

    }

}
