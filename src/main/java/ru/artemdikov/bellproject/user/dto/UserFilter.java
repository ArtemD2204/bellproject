package ru.artemdikov.bellproject.user.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Фильтр для User
 */
public class UserFilter {
    /**
     * Имя
     */
    @Size(max = 50)
    private String firstName;

    /**
     * Фамилия
     */
    @Size(max = 50)
    private String secondName;

    /**
     * Отчество
     */
    @Size(max = 50)
    private String middleName;

    /**
     * Должность
     */
    @Size(max = 100)
    private String position;

    /**
     * id офиса
     */
    @Min(value = 1, message = "officeId should not be less than 1")
    @NotNull(message = "officeId cannot be null")
    private Long officeId;

    /**
     * Код документа
     */
    private String docCode;

    /**
     * Код страны
     */
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
