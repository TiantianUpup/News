package com.cqupt.myproject.util;

/**
 * 对返回的结果进行封装
 * @author hetiantian
 * @version 2017/11/12.
 */
public class Result {
    //返回的状态，0为失败，1为成功
    private String status;
    //相关信息
    private String message;
    //封装的数据
    private Object data;

    public Result() {
    }

    public Result(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //get and set
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
