package com.dfz.boot.service.impl;

import com.dfz.boot.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Author DFZ
 * @Date 2021-06-24 16:28
 */
@Service
public class HelloServiceBImpl implements HelloService {

    @Override
    public String sayHi() {
        return "HelloServiceBImpl";
    }

}
