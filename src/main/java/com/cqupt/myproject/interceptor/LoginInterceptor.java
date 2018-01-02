package com.cqupt.myproject.interceptor;


import com.cqupt.myproject.entity.Administrator;
import com.cqupt.myproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义登陆拦截器,看用户是否有进行登陆
 * @author hetiantian
 * @version  2017/11/6.
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //根据用户是否有登录账号进行拦截
        //如果有，则跳转到需要进行验证的控制层中，否则需要登录
        Object administrator = httpServletRequest.getSession().getAttribute("loginAccount");
        System.out.println("管理员信息：" + administrator);


        if (administrator == null) {
            System.out.println("尚未登陆，跳转到登录页面");
            System.out.println("出错原因是什么");
            httpServletResponse.sendRedirect("/administrator_login.html");
            return false;
        }

        System.out.println("拦截方法稍微有点问题,返回true就会报get405错误");
        return true;



    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterComplete");
    }
}
