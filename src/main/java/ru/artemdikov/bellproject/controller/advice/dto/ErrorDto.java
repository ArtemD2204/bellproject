package ru.artemdikov.bellproject.controller.advice.dto;

/**
 * DTO класс, хранящий сообщение об ошибе
 */
public class ErrorDto {
    /**
     * Сообщение об ошибе
     */
    private String error;

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
