package ru.artemdikov.bellproject.user.dto;

import ru.artemdikov.bellproject.validation.group.Default;
import ru.artemdikov.bellproject.validation.group.OnCreate;
import ru.artemdikov.bellproject.validation.group.OnUpdate;

import javax.validation.constraints.*;

/**
 * DTO класс для работы с User
 */
public class UserDto {

    /**
     * Идентификатор
     */
    @Null(groups = OnCreate.class)
    @Min(value = 1, message = "id should not be less than 1", groups = OnUpdate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    /**
     * Имя
     */
    @Size(max = 50, groups = Default.class)
    @NotEmpty(message = "firstName cannot be empty", groups = Default.class)
    private String firstName;

    /**
     * Фамилия
     */
    @Size(max = 50, groups = Default.class)
    private String secondName;

    /**
     * Отчество
     */
    @Size(max = 50, groups = Default.class)
    private String middleName;

    /**
     * Должность
     */
    @Size(max = 100, groups = Default.class)
    @NotEmpty(message = "position cannot be empty", groups = Default.class)
    private String position;

    /**
     * Телефон
     */
    @Size(max = 30, groups = Default.class)
    private String phone;

    /**
     * Идентифицирован
     */
    private Boolean isIdentified;

    /**
     * id офиса
     */
    @Min(value = 1, message = "officeId should not be less than 1", groups = Default.class)
    @NotNull(groups = OnCreate.class)
    private Long officeId;

    /**
     * Код документа
     */
    @Size(min = 2, max = 2, groups = Default.class)
    private String docCode;

    /**
     * Название документа
     */
    private String docName;

    /**
     * Номер документа
     */
    private String docNumber;

    /**
     * Дата документа
     */
    private String docDate;

    /**
     * Код страны
     */
    @Size(min = 3, max = 3, groups = Default.class)
    private String citizenshipCode;

    /**
     * Название страны
     */
    private String citizenshipName;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }
}
