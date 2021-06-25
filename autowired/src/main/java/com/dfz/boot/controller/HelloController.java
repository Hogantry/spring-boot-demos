package com.dfz.boot.controller;

import com.dfz.boot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @Author DFZ
 * @Date 2021-06-24 16:30
 * @Description
 */
@Controller
public class HelloController {

    /**
     * @Autowired注解默认先使用类型去IOC，如果匹配多个，再根据字段名字作为 beanName 从匹配出的多个bean中查询，找出唯一的一个注入，否则报错。
     */
    @Autowired
    private HelloService helloServiceAImpl;

    /**
     * @Autowired注解注入数组或者集合时，先根据类型从IOC中获取bean，然后将bean排序后注入
     */
    @Autowired
    private HelloService[] helloServices;

    @Autowired
    private List<HelloService> helloServiceList;

    @PreDestroy
    private void destroy() {
        for (HelloService helloService : helloServices) {
            System.out.println(helloService.sayHi());
        }
        System.out.println("----------");
        for (HelloService helloService : helloServiceList) {
            System.out.println(helloService.sayHi());
        }
    }

}
