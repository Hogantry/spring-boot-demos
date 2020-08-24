package com.dfz.boot.circle1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName ConfigurationA
 * @Description ConfigurationA
 * @Author dfz
 * @Date 2019-11-08 16:24
 * @Version 1.0
 **/
public class ConfigurationA {

    @Autowired
    private BeanB beanB;

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

}
