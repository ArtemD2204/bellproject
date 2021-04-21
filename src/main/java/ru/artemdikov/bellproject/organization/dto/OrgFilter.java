package ru.artemdikov.bellproject.organization.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Фильтр для Organization
 */
public class OrgFilter {

    /**
     * Название
     */
    @NotEmpty(message = "name cannot be empty")
    @Size(max = 150)
    private String name;

    /**
     * ИНН
     */
    @Size(max = 20)
    private String inn;

    /**
     * Активный
     */
    private Boolean isActive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
