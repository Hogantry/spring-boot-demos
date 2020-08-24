package com.dfz.boot.property.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @author: DFZ
 * @description: 2
 * @date: 2020/3/9 15:39
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@ConfigurationProperties(prefix = "cust")
@Component
@Getter
@Setter
@ToString
public class User2Bean {

    private List<String> name = new ArrayList<>(); //接收prop2里面的属性值

}
