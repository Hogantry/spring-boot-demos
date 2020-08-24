package com.dfz.boot;

import com.dfz.boot.circle1.TestImport;
import com.dfz.boot.circle2.Bean2;
import com.dfz.boot.circle2.Test2Import;
import com.dfz.boot.circle3.BeanA;
import com.dfz.boot.circle3.BeanB;
import com.dfz.boot.circle3.CircleConfig;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName CircleApplication
 * @Description 测试在Springboot中可能存在的循环引用问题
 * @Author dfz
 * @Date 2019-11-13 10:36
 * @Version 1.0
 **/
public class CircleApplication {

    public static void main(String[] args) {

//        SpringApplication.run(TestImport.class, args);

//        ConfigurableApplicationContext context = SpringApplication.run(Test2Import.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(CircleConfig.class, args);
        try {
            BeanA bean1 = context.getBean(BeanA.class);
            BeanB bean2 = context.getBean(BeanB.class);
            System.out.println(bean1 + "---" + bean1.getBeanB());
            System.out.println(bean2 + "---" + bean2.getBeanA());
        } catch (BeansException e) {
            System.err.println("error:" + e);
        }
    }

}
