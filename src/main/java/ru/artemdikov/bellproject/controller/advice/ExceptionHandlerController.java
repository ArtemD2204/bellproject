package ru.artemdikov.bellproject.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.artemdikov.bellproject.controller.advice.dto.ErrorDto;
import ru.artemdikov.bellproject.exception.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final char MIN_LETTER = 65;
    private final char MAX_LETTER = 90;
    private final char MIN_DIGIT = 48;
    private final char MAX_DIGIT = 57;

    @ExceptionHandler({EntityNotFoundException.class, javax.validation.ConstraintViolationException.class})
    public ResponseEntity<ErrorDto> unhandledException(Exception e) {
        log.error(e.getMessage());
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError(e.getMessage());
        ResponseEntity<ErrorDto> responseEntity;
        if (e.getClass() == EntityNotFoundException.class) {
            responseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto unhandledInternalServerException(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error code: ");
        appendRandomChars(sb);
        for (int i = 0; i < 3; i++) {
            sb.append("-");
            appendRandomChars(sb);
        }
        log.error(sb.toString() + ". " + e.getMessage());
        printCauseAndStackTraceToLog(e);
        sb.append(". Internal server error. We apologize for this temporary inconvenience.");
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError(sb.toString());
        return errorDto;
    }

    private void printCauseAndStackTraceToLog(Throwable t) {
        Throwable cause = t.getCause();
        if (cause != null) {
            log.error("Caused by: " + t.getCause().toString());
        }
        StackTraceElement[] stackTraceElements = t.getStackTrace();
        if (stackTraceElements != null) {
            for (StackTraceElement element : stackTraceElements) {
                log.error(element.toString());
            }
        }
    }

    private void appendRandomChars(StringBuilder sb) {
        for (int i = 0; i < 4; i++) {
            sb.append(randomDigitOrLetter());
        }
    }

    private char randomDigitOrLetter() {
        int isDigit = randomInt(0, 2);
        if (isDigit == 1) {
            return (char) randomInt(MIN_DIGIT, MAX_DIGIT + 1);
        } else {
            return (char) randomInt(MIN_LETTER, MAX_LETTER + 1);
        }
    }

    private int randomInt( int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
}
