package com.cqupt.myproject.service;


import com.cqupt.myproject.entity.Administrator;

/**
 * 登陆服务接口
 * @author hetiantian
 * @version 2017/11/7.
 */
public interface LoginService {
    boolean isLogin(Administrator administrator);
}
