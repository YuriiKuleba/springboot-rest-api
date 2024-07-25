package com.yk.spring.springboot.springboot_rest_api.exception_hendling;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String message) {
        super(message);
    }
}
