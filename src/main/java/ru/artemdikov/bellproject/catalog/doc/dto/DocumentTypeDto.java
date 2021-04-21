package ru.artemdikov.bellproject.catalog.doc.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Вид документа DTO
 */
public class DocumentTypeDto {

    /**
     * Код вида документа
     */
    @Size(max = 2, min = 2)
    @NotEmpty(message = "code cannot be null")
    private String code;

    /**
     * Название вида документа
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
