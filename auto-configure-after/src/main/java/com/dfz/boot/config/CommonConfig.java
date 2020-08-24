package com.dfz.boot.config;

import com.dfz.boot.component.Person;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version V1.0
 * @author: DFZ
 * @description: 配置类
 * @date: 2020/8/12 15:13
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(name = "org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration")
public class CommonConfig {

    @Bean
    public Person person() {
        return new Person();
    }

}
