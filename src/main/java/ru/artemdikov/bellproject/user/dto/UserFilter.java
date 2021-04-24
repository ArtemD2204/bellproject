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

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }
}
