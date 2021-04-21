package ru.artemdikov.bellproject.office.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Офис DTO
 * Сокращенная информация об офисе
 */
public class OfficeDtoShort {

    /**
     * Идентификатор
     */
    @Min(value = 1, message = "id should not be less than 1")
    @NotNull
    private Long id;

    /**
     * Название
     */
    @Size(max = 150)
    @NotEmpty(message = "name cannot be null")
    private String name;

    /**
     * Активный
     */
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
