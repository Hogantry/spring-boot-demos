package com.dfz.boot.aop.service.impl;

import com.dfz.boot.aop.annotation.Dfz;
import com.dfz.boot.aop.service.FooService;
import com.dfz.boot.aop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description 被aop增强的类
 * @Author dfz
 * @Date 2019-11-13 10:30
 * @Version 1.0
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Dfz
    @Cacheable("abc")
    public void sayHello(String abc) {
        System.out.println("say Hello");
    }

    @Autowired
    private FooService fooService;

}
