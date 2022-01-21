package com.dfz.boot.aop.porcessor;

import com.dfz.boot.aop.service.impl.FooServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version V1.0
 * @author: DFZ
 * @description: 自定义BeanPostProcessor时，千万不要在接口方法中修改返回的对象，一般都会返回代理对象，但千万不要这么做，
 *               这么做导致的后果就是，当项目中存在循环引用时，会出现{@BeanCurrentlyInCreationException}异常，如果
 *               需要实现自定义的代理对象，请实现{@SmartInstantiationAwareBeanPostProcessor}接口，在
 *               getEarlyBeanReference方法中，返回代理对象。
 * @date: 2020/8/31 17:07
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == FooServiceImpl.class) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return method.invoke(proxy, args);
                }
            });
        }
        return bean;
    }
}
