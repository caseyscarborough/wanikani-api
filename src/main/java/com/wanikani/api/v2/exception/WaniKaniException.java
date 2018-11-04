package com.wanikani.api.v2.exception;

public class WaniKaniException extends RuntimeException {

    public WaniKaniException() {
    }

    public WaniKaniException(String message) {
        super(message);
    }

    public WaniKaniException(String message, Throwable cause) {
        super(message, cause);
    }

    public WaniKaniException(Throwable cause) {
        super(cause);
    }

    public WaniKaniException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
