package com.dfz.boot.main;

import com.dfz.boot.component.Person;
import com.dfz.boot.config.AutoConfigureTimeApplication2;
import com.dfz.boot.config.CommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

import javax.annotation.Priority;

/**
 * @version V1.0
 * @author: DFZ
 * @description: 自动配置生效时机
 *               @AutoConfigureAfter 和 @AutoConfigureBefore即使配置的类不存在，不影响本类会被加载进IOC容器中
 *
 *               ConfigurationClassPostProcessor#processConfigBeanDefinitions方法推测，只有主配置类是多个时（一般
 *               我们也就只在启动类中配置一个主配置类），这些配置类支持@Order注解来规定按照一定顺序来解析这些配置类，但这些配置
 *               类的实例化顺序依然是无序的。其他通过如注解@Component/@Import等导入的配置类，不支持排序功能？
 * @date: 2020/8/12 15:09
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@SpringBootApplication
@Order(1)
public class AutoConfigureTimeApplication {

    public AutoConfigureTimeApplication() {
        System.out.println("AutoConfigureTimeApplication");
    }

    public static void main(String[] args) {
        Class<?>[] classes = {AutoConfigureTimeApplication2.class, AutoConfigureTimeApplication.class};
        ConfigurableApplicationContext context = SpringApplication.run(classes, args);
        Person bean = context.getBean(Person.class);
        if (bean == null) {
            System.out.println("no person bean");
        } else {
            System.out.println(bean);
        }
    }

}
