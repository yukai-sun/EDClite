package org.eclipse.edc;

public class EdcException extends RuntimeException {

    // constructor
    public EdcException(String message) {
        super(message);
    }

    public EdcException(String message, Throwable cause) {
        super(message, cause);
    }

    public EdcException(Throwable cause) {
        super(cause);
    }

    public EdcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
