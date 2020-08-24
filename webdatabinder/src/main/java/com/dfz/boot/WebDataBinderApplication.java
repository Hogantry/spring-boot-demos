package com.dfz.boot;

import com.dfz.boot.module.IDCard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ClassUtils;

/**
 * @version V1.0
 * @author: DFZ
 * @description: bootstrap class
 * @date: 2020/3/27 10:01
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@SpringBootApplication
public class WebDataBinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDataBinderApplication.class, args);
        System.out.println(ClassUtils.getShortNameAsProperty(IDCard.class));
    }

}
