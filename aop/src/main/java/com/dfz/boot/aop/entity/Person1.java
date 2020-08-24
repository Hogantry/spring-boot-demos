package com.dfz.boot.aop.entity;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @author: DFZ
 * @description: Person1
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
