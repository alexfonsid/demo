package com.myPJ.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException extends Exception {
    public CustomException() {
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Can't ADD")
    public void exceptionCantAdd() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Can't UPDATE")
    public void exceptionCantUpdate() {}

}
