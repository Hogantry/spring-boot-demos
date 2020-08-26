package com.dfz.boot.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName BlogProperties
 * @Description BlogProperties
 * @Author dfz
 * @Date 2019-07-22 13:41
 * @Version 1.0
 **/
@Order(2)
@Component
public class BlogProperties {

    public BlogProperties() {
        System.out.println("BlogProperties");
    }

    @Value("${com.dfz.name}")
    private String name;
    @Value("${com.dfz.title}")
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BlogProperties{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
