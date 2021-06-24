package com.dfz.boot.controller;

import com.dfz.boot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author DFZ
 * @Date 2021-06-24 16:30
 * @Description  @Autowired注解默认先使用类型去IOC，如果匹配多个，再根据字段名字作为 beanName 从匹配出的多个bean中查询，找出唯一的一个注入，否则报错。
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloServiceAImpl;

}
