package com.dfz.boot.service.impl;

import com.dfz.boot.service.HelloService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DFZ
 * @Title:
 * @Package
 * @Description:
 * @date 2021-06-0718:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class HelloServiceImplTest {

    @Resource
    private HelloService helloService;

    @Test
    void sayHello() {
        Assert.assertEquals("hello", helloService.sayHello());
    }
}