package ru.artemdikov.bellproject.user.dto;

import javax.validation.constraints.*;

public class UserDto {
//    @NotEmpty     ???
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

    @Size(max = 30)
    private String phone;

    private Boolean isIdentified;

    @NotNull(message = "officeId cannot be null")
    private Long officeId;

    @NotEmpty(message = "docCode cannot be null")
    private String docCode;

    private String docName;

    @NotEmpty(message = "docNumber cannot be null")
    private String docNumber;

    @NotEmpty(message = "docDate cannot be null")
    private String docDate;

    private String citizenshipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDocName(String docName) {
        this.docName = docName;
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

    public String getDocName() {
        return docName;
    }
}
