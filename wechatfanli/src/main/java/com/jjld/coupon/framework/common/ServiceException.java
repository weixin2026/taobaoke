package com.jjld.coupon.framework.common;

public class ServiceException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	public ServiceException() {
        super();
    }

    public ServiceException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

}
