package ru.artemdikov.bellproject.user.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserFilter {
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String secondName;

    @Size(max = 50)
    private String middleName;

    @Size(max = 100)
    private String position;

    @Min(value = 1, message = "officeId should not be less than 1")
    @NotNull(message = "officeId cannot be null")
    private Long officeId;

    private String docCode;

    private String citizenshipCode;

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public String getDocCode() {
        return docCode;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }
}
