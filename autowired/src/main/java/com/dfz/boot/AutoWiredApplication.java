package com.dfz.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author DFZ
 * @Date 2021-06-24 16:24
 * @Description 与 {@link Autowired} 注解相关的分析与案例，具体参考各个controller中的注释与代码
 */
@SpringBootApplication
public class AutoWiredApplication {

    public static void main(String[] args) {

        SpringApplication.run(AutoWiredApplication.class, args);

    }

}
