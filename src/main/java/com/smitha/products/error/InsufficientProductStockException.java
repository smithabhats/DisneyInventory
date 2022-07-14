package com.smitha.products.error;

public class InsufficientProductStockException extends Exception{
    public InsufficientProductStockException() {
        super();
    }

    public InsufficientProductStockException(String message) {
        super(message);
    }

    public InsufficientProductStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientProductStockException(Throwable cause) {
        super(cause);
    }

    protected InsufficientProductStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
