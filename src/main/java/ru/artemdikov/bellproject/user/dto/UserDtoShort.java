package ru.artemdikov.bellproject.user.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDtoShort {
    private Long id;

    @Size(max = 50)
    @NotEmpty(message = "firstName cannot be null")
    private String firstName;

    @Size(max = 50)
    private String secondName;

    @Size(max = 50)
    private String middleName;

    @Size(max = 100)
    @NotEmpty(message = "position cannot be null")
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
