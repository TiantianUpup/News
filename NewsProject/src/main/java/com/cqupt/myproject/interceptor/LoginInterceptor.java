package com.cqupt.myproject.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义登陆拦截器
 * @author hetiantian
 * @version  2017/11/6.
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //根据用户是否有登录账号进行拦截
        //如果有，则跳转到需要进行验证的控制层中，否则需要登录
        Object administrator = httpServletRequest.getSession().getAttribute("loginAccount");
        if (administrator == null) {
            System.out.println("尚未登陆，跳转到登录页面");
            httpServletResponse.sendRedirect("/login.html");
            return false;
        }

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterComplete");
    }
}
