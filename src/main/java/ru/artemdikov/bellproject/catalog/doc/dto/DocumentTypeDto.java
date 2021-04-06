package ru.artemdikov.bellproject.catalog.doc.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DocumentTypeDto {

    @Size(max = 2, min = 2)
    @NotEmpty(message = "code cannot be null")
    private String code;

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
