package com.pincode.exception;

public class PincodeException extends RuntimeException{

	private static final long serialVersionUID = -8885162875301327175L;

	public PincodeException() {
        super();
    }

    public PincodeException(String message) {
        super(message);
    }

    public PincodeException(String message, Throwable cause) {
        super(message, cause);
    }

}
