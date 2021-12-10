package com.dfz.mvc.controller;

import com.dfz.mvc.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @author: DFZ
 * @description: LocalDate
 * @date: 2020/9/7 14:05
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@RestController
@RequestMapping("local-date")
public class LocalDateController {

    @GetMapping("date")
    public String date(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") LocalDate date) {
        return date.toString();
    }

    @GetMapping("dateTime")
    public String datetime(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
        return dateTime.toString();
    }

    @GetMapping("date2/{date}")
    public String date2(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") LocalDate date) {
        return date.toString();
    }

    @GetMapping("date3")
    public String date3(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") LocalDate date) {
        return date.toString();
    }

    @GetMapping("date4")
    public String date4(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date date) {
        return date.toString();
    }

    @GetMapping("date5")
    public String date5(Date date) {
        return date.toString();
    }

    @GetMapping("dateTime4")
    public String dateTime4(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        return date.toString();
    }

    @GetMapping("getUser")
    public User getUser() {
        User user = new User();
        user.setBirthday(LocalDateTime.now());
        user.setBirthday2(new Date());
        return user;
    }

    @PostMapping("createUser")
    public void createUser(@RequestBody User user) {
        System.out.println(user);
    }

}
