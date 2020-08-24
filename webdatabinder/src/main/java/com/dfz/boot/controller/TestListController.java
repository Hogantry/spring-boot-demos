package com.dfz.boot.controller;

import com.dfz.boot.module.User;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @author: DFZ
 * @description: TestList
 * @date: 2020/3/27 10:02
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@RestController
@RequestMapping("test")
public class TestListController {

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public void testList(User b, HttpSession session) {
        System.out.println("DFZ");
        session.invalidate();
        System.out.println(b);
    }

}
