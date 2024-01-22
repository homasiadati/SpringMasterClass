package com.homa213.springmasterclass.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;

public class ApiException {
    private final String message;

    private final List<String> errorMessages;

    private final Throwable throwable;

    private final HttpStatus httpStatus;

    private final ZonedDateTime time;

    public ApiException(String message, List<String> errorMessages, Throwable throwable, HttpStatus httpStatus, ZonedDateTime time) {
        this.message = message;
        this.errorMessages = errorMessages;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                ", throwable=" + throwable +
                ", httpStatus=" + httpStatus +
                ", time=" + time +
                '}';
    }
}

