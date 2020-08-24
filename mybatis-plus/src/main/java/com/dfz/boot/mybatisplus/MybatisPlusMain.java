package com.dfz.boot.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @version V1.0
 * @author: DFZ
 * @description: mybatis-plus
 *               项目使用事务功能，只需要依赖相应依赖即可，例如spring-boot-starter-aop模块，在spring-boot-autoconfigure模块中，会
 *  *            自动引入AOP相关的配置类，不需要在添加@EnableTransactionManagement注解，具体可参考TransactionAutoConfiguration类
 * @date: 2020/4/21 14:17
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@SpringBootApplication
//@EnableTransactionManagement
public class MybatisPlusMain {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusMain.class, args);
    }

}
