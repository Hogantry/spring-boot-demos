package com.dfz.boot.service.impl;

import com.dfz.boot.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author DFZ
 * @Title:
 * @Package
 * @Description:
 * @date 2021-06-0718:08
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello";
    }

}
