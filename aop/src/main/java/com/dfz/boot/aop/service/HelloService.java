package com.dfz.boot.aop.service;

import com.dfz.boot.aop.annotation.Dfz;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description 被aop增强的类
 * @Author dfz
 * @Date 2019-11-13 10:30
 * @Version 1.0
 **/
@Service
public class HelloService {

    @Dfz
    public void sayHello() {
        System.out.println("say Hello");
    }

}