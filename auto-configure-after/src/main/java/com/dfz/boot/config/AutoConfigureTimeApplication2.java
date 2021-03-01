package com.dfz.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @version V1.0
 * @author: DFZ
 * @description: AutoConfigureTimeApplication2
 * @date: 2020/9/29 15:37
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Configuration
@Order(3)
public class AutoConfigureTimeApplication2 {

    public AutoConfigureTimeApplication2() {
        System.out.println("AutoConfigureTimeApplication2");
    }
}
