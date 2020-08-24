package com.dfz.boot.property.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserBean
 * @Description UserBean
 * @Author dfz
 * @Date 2019-11-18 13:48
 * @Version 1.0
 **/
//@ConfigurationProperties(prefix = "com.dfz")
//@Component
@Data
public class UserBean {

    private String name;
    private String title;

}
