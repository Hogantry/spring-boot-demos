package com.dfz.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 8653167547320297351L;

    private Long id;

    private String name;

    private Integer age;

    private Date createTime;

    private Date updateTime;
}