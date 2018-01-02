package com.cqupt.myproject.exception;

/**
 * Created by I am master on 2017/11/9.
 */
public class ErrorException extends RuntimeException {
    private String error;

    public ErrorException(String error) {
        super(error);
    }
}
