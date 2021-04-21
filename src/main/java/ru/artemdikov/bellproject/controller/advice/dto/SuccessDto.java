package ru.artemdikov.bellproject.controller.advice.dto;

/**
 * DTO класс, хранящий сообщение об успешном выполнении
 */
public class SuccessDto {
    /**
     * Сообщение об успешном выполнении
     */
    private String result = "success";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
