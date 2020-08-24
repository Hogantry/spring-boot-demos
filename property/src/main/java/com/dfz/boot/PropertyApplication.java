package com.dfz.boot;

import com.dfz.boot.property.service.HumerService;
import com.dfz.boot.property.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName PropertyApplication
 * @Description @ConfigurationProperties可定义在一个POJO上，意为该POJO进行属性绑定。如果同时添加了@Component注解，则不需要@EnableConfigurationProperties。
 * 如果没有添加，则必须添加@EnableConfigurationProperties注解，他引入了两个ImportBeanDefinitionRegistrar接口类，
 * ConfigurationPropertiesBeanRegistrar 和 ConfigurationPropertiesBindingPostProcessorRegistrar，且定义该注解的value值，为该POJO。
 *
 * 如需要在POJO上加@PropertySource注解，并制定配置文件的路径。由于@PropertySource注解的解析过程比较靠前，因此如果想该注解生效，则应该同时在该POJO上
 * 添加@Component或者@Configuration注解
 * @Author dfz
 * @Date 2019-11-18 13:46
 * @Version 1.0
 **/
@SpringBootApplication
//@EnableConfigurationProperties
public class PropertyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PropertyApplication.class, args);
        HumerService humerService = context.getBean(HumerService.class);
        humerService.humber();
    }

}
