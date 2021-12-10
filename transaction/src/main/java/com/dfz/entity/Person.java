package com.dfz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * person
 * @author 
 */
@Data
public class Person implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private static final long serialVersionUID = 1L;
}