package com.dfz.boot.circle2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Configuration1
 * @Description Configuration1
 * @Author dfz
 * @Date 2019-11-13 09:58
 * @Version 1.0
 **/
@Configuration
public class Configuration1 {

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }

}
