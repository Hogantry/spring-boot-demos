package com.dfz.boot.lettuce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version V1.0
 * @author: DFZ
 * @description: Lettuce redis 测试
 * @date: 2020/4/9 16:25
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@SpringBootApplication
public class LettuceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LettuceApplication.class, args);
    }

}
