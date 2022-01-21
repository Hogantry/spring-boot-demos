package com.dfz.boot.aop.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version V1.0
 * @author: DFZ
 * @description: 项目依赖spring-boot-starter-aop，会自动引入{@link AnnotationAwareAspectJAutoProxyCreator}，如果此时再引入
 *               {@link DefaultAdvisorAutoProxyCreator}，会导致增强被重复织入而报错。
 *
 *               简单理解就是一个项目里请保证只有AutoProxyCreator
 * @date: 2020/5/22 09:39
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Configuration
public class AopConfig {

//    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

}
