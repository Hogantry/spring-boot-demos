package com.dfz.boot.circle1;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName BeanB
 * @Description BeanB
 * @Author dfz
 * @Date 2019-11-08 16:24
 * @Version 1.0
 **/
public class BeanB {

    @Autowired
    private BeanA beanA;
}
