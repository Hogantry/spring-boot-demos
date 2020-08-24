package com.dfz.boot.property.service;

import com.dfz.boot.property.pojo.PersonBean;
import com.dfz.boot.property.pojo.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description UserService
 * @Author dfz
 * @Date 2019-11-18 13:51
 * @Version 1.0
 **/
//@Service
//@EnableConfigurationProperties(UserBean.class)
@Slf4j
public class UserService {

    @Autowired
    private UserBean userBean;

    @Autowired
    private PersonBean personBean;

    public void sayHi() {
        log.info(userBean.toString());
    }

    public void sayLove() {
        log.info(personBean.toString());
    }
}
