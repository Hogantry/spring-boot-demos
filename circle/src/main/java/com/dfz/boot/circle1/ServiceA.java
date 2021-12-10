package com.dfz.boot.circle1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName ServiceA
 * @Description ServiceA
 * @Author dfz
 * @Date 2019-11-08 16:23
 * @Version 1.0
 **/
@Slf4j
public class ServiceA {

    public ServiceA() {
        log.info("ServiceA");
    }

    @Autowired
    private BeanA beanA;

    @Autowired
    private BeanB beanB;

}
