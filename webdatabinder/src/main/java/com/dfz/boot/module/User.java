package com.dfz.boot.module;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @version V1.0
 * @author: DFZ
 * @description: user
 * @date: 2020/3/27 13:20
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
public class User {

    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (CollectionUtils.isEmpty(names)) {
            return "User is null";
        }
        for (String name : names) {
            builder.append("name: " + name + "; ");
        }
        return "User{" +
                "names=" + builder.toString() +
                '}';
    }
}
