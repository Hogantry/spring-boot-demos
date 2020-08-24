package com.dfz.boot.property.service;

import com.dfz.boot.property.pojo.HumerBean;
import com.dfz.boot.property.pojo.User2Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @author: DFZ
 * @description: service
 * @date: 2020/3/9 15:00
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@Service
public class HumerService {

    @Resource
    private HumerBean humerBean;

    @Resource
    private User2Bean user2Bean;

    public void humber() {
        System.out.println(humerBean.toString() + " \n" + user2Bean.toString());
    }


}
