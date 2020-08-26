package com.dfz.boot.aop.entity;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @author: DFZ
 * @description: @Order 注解加在普通bean上时没有任何作用的，不会影响bean的加载或实例化顺序
 * @date: 2020/6/5 09:32
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Component
@Order(2)
public class Person1 {

    public Person1() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person1{}";
    }
}
