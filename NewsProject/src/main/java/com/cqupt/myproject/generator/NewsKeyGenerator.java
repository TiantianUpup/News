package com.cqupt.myproject.generator;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 指定key自定义生成器
 * @author hetiantian
 * @version 2017/11/9.
 */
@Component
public class NewsKeyGenerator implements KeyGenerator {
    public Object generate(Object o, Method method, Object... objects) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(o.getClass().getName());
//        sb.append(":" + method.getName());
//
//        for (Object obj : objects) {
//            sb.append(":" + null == obj ? null : obj.toString());
//        }
//
//        return sb;
        return "123";
    }
}
