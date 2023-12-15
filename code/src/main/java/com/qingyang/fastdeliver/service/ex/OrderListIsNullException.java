package com.qingyang.fastdeliver.service.ex;

public class OrderListIsNullException extends ServiceException{
    public OrderListIsNullException() {
        super();
    }

    public OrderListIsNullException(String message) {
        super(message);
    }

    public OrderListIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderListIsNullException(Throwable cause) {
        super(cause);
    }

    protected OrderListIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
