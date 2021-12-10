package com.dfz.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @author: DFZ
 * @description: testController
 * @date: 2020/5/20 16:43
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@RestController
@RequestMapping("netTrade-api")
public class TestController {

    @GetMapping("sleep")
    public String sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "ok";
    }

}
