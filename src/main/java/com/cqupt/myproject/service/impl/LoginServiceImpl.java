package com.cqupt.myproject.service.impl;


import com.cqupt.myproject.dao.LoginDao;
import com.cqupt.myproject.entity.Administrator;
import com.cqupt.myproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登陆服务实现类
 * @author hetiantian
 * @version 2017/11/7.
 */
@Service
public class LoginServiceImpl implements LoginService {
    public String test() {
        return "success";
    }
    @Autowired
    private LoginDao loginDao;

    public boolean isLogin(Administrator administrator) {
        String loginAccount = administrator.getLoginAccount();
        String expectPassword = administrator.getPassword();
        String serchPassword = loginDao.findAdministratorByName(loginAccount);

        if (expectPassword.equals(serchPassword)) {
            return true;
        }
            return false;
    }
}
