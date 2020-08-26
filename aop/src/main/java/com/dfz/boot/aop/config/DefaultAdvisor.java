package com.dfz.boot.aop.config;

import com.dfz.boot.aop.annotation.Dfz;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @version V1.0
 * @author: DFZ
 * @description: advisor
 * @date: 2020/5/22 09:48
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
//@Component
public class DefaultAdvisor extends StaticMethodMatcherPointcutAdvisor {

    private static final Class<? extends Annotation>[] AUTHZ_ANNOTATION_CLASSES = new Class[]{Dfz.class};

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        Method m = method;
        if (this.isAuthzAnnotationPresent(method)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isAuthzAnnotationPresent(Method method) {
        Class[] var2 = AUTHZ_ANNOTATION_CLASSES;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Class<? extends Annotation> annClass = var2[var4];
            Annotation a = AnnotationUtils.findAnnotation(method, annClass);
            if (a != null) {
                return true;
            }
        }

        return false;
    }
}
