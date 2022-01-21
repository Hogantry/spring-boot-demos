package com.dfz.mvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

/**
 * person
 *
 * @author 花葱
 * @date 2021/12/29 09:32
 */
@Data
public class Person {

    private String name;

    private Integer age;

    private String address;

    /**
     * 前端返回json过滤该字段
     */
    @JsonIgnore
    private LocalDate birthday;

}
