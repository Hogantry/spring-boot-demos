package com.dfz.boot.main;

import com.dfz.boot.component.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @version V1.0
 * @author: DFZ
 * @description: 自动配置生效时机
 *               @AutoConfigureAfter 和 @AutoConfigureBefore即使配置的类不存在，不影响本类会被加载进IOC容器中
 * @date: 2020/8/12 15:09
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@SpringBootApplication
public class AutoConfigureTimeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AutoConfigureTimeApplication.class);
        Person bean = context.getBean(Person.class);
        if (bean == null) {
            System.out.println("no person bean");
        } else {
            System.out.println(bean);
        }
    }

}
