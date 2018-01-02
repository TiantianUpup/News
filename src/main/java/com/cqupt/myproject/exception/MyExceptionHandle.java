package com.cqupt.myproject.exception;

import com.cqupt.myproject.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 自定义异常捕获器
 * @author hetiantian
 * @version 2017/11/12.
 */
@RestControllerAdvice
public class MyExceptionHandle {

    @ExceptionHandler(value = ErrorException.class)
    public Result handleErrorException(ErrorException e) {
        Result result = new Result("0", e.getMessage(), null);
        return result;
    }

}
