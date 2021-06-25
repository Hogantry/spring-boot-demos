package com.dfz.boot.service.impl;

import com.dfz.boot.service.HelloService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @Author DFZ
 * @Date 2021-06-24 16:27
 */
@Service
@Order(4)
public class HelloServiceAImpl implements HelloService {

    @Override
    public String sayHi() {
        return "HelloServiceAImpl";
    }

}
