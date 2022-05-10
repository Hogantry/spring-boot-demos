package com.dfz.mvc.service.impl;

import com.dfz.mvc.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * person
 *
 * @author 花葱
 * @date 2022/1/23 17:38
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public void sayHello() {
        RuntimeException base = new RuntimeException("base");
        base.setStackTrace(null);
    }

}
