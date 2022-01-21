package com.dfz.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DFZ
 * @Title:
 * @Package
 * @Description:
 * @date 2021-06-0717:26
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

}
