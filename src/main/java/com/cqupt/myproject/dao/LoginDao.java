package com.cqupt.myproject.dao;

import org.springframework.stereotype.Repository;

/**
 * 登陆持久化层
 * @author hetiantian
 * @version 2017/11/7.
 */
@Repository
public interface LoginDao {
    String findAdministratorByName(String loginAccount);
}
