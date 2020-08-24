package com.dfz.boot.property.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName PersonBean
 * @Description PersonBean
 * @Author dfz
 * @Date 2019-11-18 13:57
 * @Version 1.0
 **/
//@ConfigurationProperties(prefix = "com.lhr")
@PropertySource(value = "classpath:test.properties")
//@Component
@Data
public class PersonBean {

    private String name;
    private String age;

}
