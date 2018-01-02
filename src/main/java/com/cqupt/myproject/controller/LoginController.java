package com.cqupt.myproject.controller;

import com.cqupt.myproject.entity.Administrator;
import com.cqupt.myproject.service.LoginService;
import com.cqupt.myproject.util.CookieUtil;
import com.cqupt.myproject.util.EncryptUtil;
import com.cqupt.myproject.util.Result;
import com.cqupt.myproject.util.ResultUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public String save (@RequestBody Administrator administrator, HttpServletRequest httpServletRequest) {
//        Administrator administrator = new Administrator("dayday", "123", true);
        System.out.println("Enter....................................................");
        String loginAccount = administrator.getLoginAccount();
        String password = administrator.getPassword();
        Boolean check = administrator.getCheck();

        System.out.println("loginAccount: " + loginAccount);
        System.out.println("password: " + password);
        System.out.println("check: " + check);

        //将用户信息保存在session中,检查是否登陆
        httpServletRequest.getSession().setAttribute("loginAccount", loginAccount);
        httpServletRequest.getSession().setAttribute("password", password);
        httpServletRequest.getSession().setAttribute("check", check);


        //重定向url,该url需要被拦截器所拦截到
        return "/administrator/login";
    }

    @RequestMapping(value = "/administrator/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        System.out.println("--------------------------------------------------------------");
        Administrator administrator = new Administrator();
        String loginAccount = (String) httpServletRequest.getSession().getAttribute("loginAccount");
        String password = (String) httpServletRequest.getSession().getAttribute("password");
        Boolean check = (Boolean)httpServletRequest.getSession().getAttribute("check");

        System.out.println("用户名：" + loginAccount);
        System.out.println("密码：" + password);
        System.out.println("是否记住密码：" + check);

        administrator.setLoginAccount(loginAccount);
        administrator.setPassword(password);
        administrator.setCheck(check);
        boolean isLogin = loginService.isLogin(administrator);
//        模拟登陆数据
//        Boolean isLogin = true;
//        Boolean check = true;
//        String loginAccount = "dayday";
//        String password = "123";

        System.out.println("是否登陆:" + isLogin);

        if (!isLogin) {  //如果密码不正确
            //查看加密以后的数据
            System.out.println("加密以后的用户账号:" + EncryptUtil.encryptMD5(loginAccount));
            System.out.println("加密以后的密码:" + EncryptUtil.encryptMD5(password));
            return ResultUtil.successResult(0);
        } else {
            //如果登陆成功，并且要求记住密码，则向客户端发送cookie,并且对cookie中的用户账号和密码进行加密
            if (check) {
                CookieUtil.addCookie(httpServletResponse, EncryptUtil.encryptMD5(loginAccount), EncryptUtil.encryptMD5(password));
                System.out.println("成功登陆");
            }

            return ResultUtil.successResult(1);
        }

//        return "/add_news.html";

    }


}
