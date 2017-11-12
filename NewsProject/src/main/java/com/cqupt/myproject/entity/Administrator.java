package com.cqupt.myproject.entity;

/**
 * 管理员实体类
 * @author hetiantian
 * @version 2017/11/7.
 */
public class Administrator {
    private Integer administratorId;
    private String loginAccount;
    private String password;

    public Administrator() {
    }

    public Administrator(Integer administratorId, String loginAccount, String password) {
        this.administratorId = administratorId;
        this.loginAccount = loginAccount;
        this.password = password;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorId=" + administratorId +
                ", loginAccount='" + loginAccount + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
