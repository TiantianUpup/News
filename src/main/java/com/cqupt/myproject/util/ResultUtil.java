package com.cqupt.myproject.util;

/**
 * 结果处理工具类，对Result进行了进一步封装
 * @author hetiantian
 * @version 2017/11/12.
 */
public class ResultUtil {

   public static final String SUCCESS = "success";
    public static Result successResult(Object data) {
        Result result = new Result("1", SUCCESS, null);

        if (data != null) {
            result.setData(data);
        }

        return result;
    }
}
