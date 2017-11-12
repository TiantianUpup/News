package com.cqupt.myproject.controller;

import com.cqupt.myproject.entity.Administrator;
import com.cqupt.myproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆控制器
 * @author hetiantian
 * @version 2017/11/6.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String save (Administrator administrator, HttpServletRequest httpServletRequest) {
        System.out.println("Administrator对象：" + administrator);
        String loginAccount = administrator.getLoginAccount();
        String password = administrator.getPassword();
        //将用户信息保存在session中
        httpServletRequest.getSession().setAttribute("loginAccount", loginAccount);
        httpServletRequest.getSession().setAttribute("password", password);
        //重定向url,该url需要被拦截器所拦截到
        return "/administrator/login?httpServletRequest";
    }

    @RequestMapping("/administrator/login")
    public String login (HttpServletRequest httpServletRequest) {
        Administrator administrator = new Administrator();
        String loginAccount = (String) httpServletRequest.getSession().getAttribute("loginAccount");
        String password = (String) httpServletRequest.getSession().getAttribute("password");
        administrator.setLoginAccount(loginAccount);
        administrator.setPassword(password);
        boolean isLogin = loginService.isLogin(administrator);

        System.out.println("是否登陆:" + isLogin);

        if (!isLogin) {
            return "/administrator_login.html";
        }

        return "/add_news.html";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
