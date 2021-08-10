package com.gavin.service;

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/10 19:14
 * * Description  : Etl 异常处理
 * * Modified by  :
 * * Version      :
 **/
public class EtlException extends RuntimeException{
    public EtlException(String message) {
        super(message);
    }

    public EtlException(String message, Throwable cause) {
        super(message, cause);
    }

    public EtlException(Throwable cause) {
        super(cause);
    }

    protected EtlException(String message, Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
