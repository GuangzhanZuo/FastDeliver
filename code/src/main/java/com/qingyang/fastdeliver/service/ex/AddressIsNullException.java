package com.qingyang.fastdeliver.service.ex;

public class AddressIsNullException extends ServiceException{
    public AddressIsNullException() {
        super();
    }

    public AddressIsNullException(String message) {
        super(message);
    }

    public AddressIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressIsNullException(Throwable cause) {
        super(cause);
    }

    protected AddressIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
