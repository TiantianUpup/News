package com.cqupt.myproject.entity;

/**
 * 管理员实体类
 * @author hetiantian
 * @version 2017/11/7.
 */
public class Administrator {
//    private Integer administratorId;
    private String loginAccount;
    private String password;
    private Boolean check;

    public Administrator() {
    }

//    public Administrator(Integer administratorId, String loginAccount, String password, Boolean check) {
//        this.administratorId = administratorId;
//        this.loginAccount = loginAccount;
//        this.password = password;
//        this.check = check;
//    }

//    public Integer getAdministratorId() {
//        return administratorId;
//    }
//
//    public void setAdministratorId(Integer administratorId) {
//        this.administratorId = administratorId;
//    }


    public Administrator(String loginAccount, String password, Boolean check) {
        this.loginAccount = loginAccount;
        this.password = password;
        this.check = check;
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

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

//    @Override
//    public String toString() {
//        return "Administrator{" +
//                "administratorId=" + administratorId +
//                ", loginAccount='" + loginAccount + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Administrator{" +
                "loginAccount='" + loginAccount + '\'' +
                ", password='" + password + '\'' +
                ", check=" + check +
                '}';
    }
}
