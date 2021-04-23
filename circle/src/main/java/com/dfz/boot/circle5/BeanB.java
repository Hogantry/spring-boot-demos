package com.dfz.boot.circle5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @author: DFZ
 * @description: beanb
 * @date: 2020/5/13 17:16
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Component
public class BeanB {

    @Autowired
    BeanA beanA;

//    @Async
    public void asyncB() {
        System.out.println("B:" + Thread.currentThread().getName());
    }

    public BeanA getBeanA() {
        return beanA;
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }
}
