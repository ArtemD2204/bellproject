package ru.artemdikov.bellproject.catalog.doc.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DocumentTypeDto {

    @Size(max = 2)
    @NotEmpty(message = "code cannot be null")
    private String code;

    @Size(max = 150)
    @NotEmpty(message = "name cannot be null")
    private String name;

}
