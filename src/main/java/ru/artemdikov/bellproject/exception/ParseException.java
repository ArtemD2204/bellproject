package ru.artemdikov.bellproject.exception;

/**
 * Signals that an error has been reached unexpectedly while parsing.
 */
public class ParseException extends RuntimeException {

    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
