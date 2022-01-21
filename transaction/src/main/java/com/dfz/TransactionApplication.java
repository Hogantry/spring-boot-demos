package com.dfz;

import com.dfz.controller.StudentController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author DFZ
 * @Date 2021-07-19 16:04
 * @Description  举例：
 *                  A -> B 如果A 、B 传播级别都为 Propagation.REQUIRED，则A和B是使用的同一个connection，如果B有抛出异常，B会回滚，
 *                         同时设置connection的rollback为true，即使在A中捕获了B抛出的异常，A事务也会回滚；
 *
 *                         如果A为Propagation.REQUIRED，B为Propagation.REQUIRES_NEW，则A和B使用的是不同的connection，
 *                         如果B抛出异常，B会回滚，如果在A中没有捕获B的异常，则A事务也会回滚，如果捕获了异常，则A事务是可以提交的
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.dfz.dao")
public class TransactionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TransactionApplication.class, args);
        StudentController studentController = context.getBean(StudentController.class);
        studentController.update();
    }

}
