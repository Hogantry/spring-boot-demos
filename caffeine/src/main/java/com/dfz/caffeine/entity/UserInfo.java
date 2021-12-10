package com.dfz.caffeine.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author DFZ
 * @Date 2021-07-05 20:35
 * @Description
 */
@Data
@ToString
public class UserInfo {

    private Integer id;
    private String name;
    private String sex;
    private Integer age;

}
