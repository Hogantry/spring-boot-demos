package com.dfz.boot.lettuce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @author: DFZ
 * @description:
 * @date: 2020/4/9 17:02
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Controller
@RequestMapping("redis")
public class LettuceController {

//    @Resource(type = StringRedisTemplate.class)
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("test")
    public String test() {
        String age2 = stringRedisTemplate.opsForValue().get("age2");
        System.out.println("age2: " + age2);
        return "age2: " + age2;
    }

}
