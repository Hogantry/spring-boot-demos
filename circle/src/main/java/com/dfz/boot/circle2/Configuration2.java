package com.dfz.boot.circle2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Configuration2
 * @Description Configuration2
 * @Author dfz
 * @Date 2019-11-13 10:00
 * @Version 1.0
 **/
@Configuration
public class Configuration2 {

    @Bean
    @ConditionalOnBean(Bean1.class)
    public Bean2 bean2() {
        return new Bean2();
    }

}
