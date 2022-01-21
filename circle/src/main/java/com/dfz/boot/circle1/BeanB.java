package com.dfz.boot.circle1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName BeanB
 * @Description BeanB
 * @Author dfz
 * @Date 2019-11-08 16:24
 * @Version 1.0
 **/
@Slf4j
public class BeanB {

    public BeanB() {
        log.info("BeanB");
    }

    @Autowired
    private BeanA beanA;
}
