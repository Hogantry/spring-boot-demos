package com.dfz.boot.circle5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @version V1.0
 * @author: DFZ
 * @description:   由于@EnableAsync的实现机制是自定义的BeanPostProcessor，而不是SmartInstantiationAwareBeanPostProcessor
 *                 所以当出现两个循环引用的类，且每个类中都使用了@Async注解，则spring是无法解决这个循环依赖问题的
 *
 *                 同时需要注意，在不考虑其他依赖的情况下，spring初始化bean是按照字典序来初始化的，本例中，BeanA会先于BeanB初始化，
 *                 因此如果BeanA有被@Async注解修饰的方法，即使BeanB中没有，spring也无法处理这个循环依赖问题
 * @date: 2021/4/8 10:53
 * @Copyright: 2021 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Configuration
@EnableAspectJAutoProxy
//@EnableAsync
@ComponentScan("com.dfz.boot.circle5")
public class Config5 {
}
