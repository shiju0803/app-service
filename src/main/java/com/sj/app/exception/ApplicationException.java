package com.sj.app.exception;

import lombok.Getter;

/**
 * 应用异常类
 *
 * @author ShiJu
 * @version 1.0
 */
@Getter
public class ApplicationException extends RuntimeException {

    private final int code;

    private final String msg;


    public ApplicationException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public ApplicationException(ApplicationExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    /**
     * avoid the expensive and useless stack trace for api exceptions
     *
     * @see Throwable#fillInStackTrace()
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
