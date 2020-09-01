package com.dfz.boot.aop.service.impl;

import com.dfz.boot.aop.service.FooService;
import com.dfz.boot.aop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @author: DFZ
 * @description: foo service
 * @date: 2020/8/31 17:10
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Service
public class FooServiceImpl implements FooService {

    @Autowired
    private HelloService helloService;

}
