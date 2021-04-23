package com.dfz.boot.circle5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @version V1.0
 * @author: DFZ
 * @description:
 * @date: 2021/4/8 13:24
 * @Copyright: 2021 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Component
@Aspect
@Priority(1)
public class Aspect2 {

    @Pointcut("execution(* com.dfz.boot.circle5.BeanA.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void begin() {
        System.out.println("开启事务2");
    }

}
