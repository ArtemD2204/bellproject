package ru.artemdikov.bellproject.catalog.country.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Страна DTO
 */
public class CountryDto {

    /**
     * Код страны
     */
    @Size(max = 3, min = 3)
    @NotEmpty(message = "code cannot be null")
    private String code;

    /**
     * Название
     */
    @Size(max = 150)
    @NotEmpty(message = "name cannot be null")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
