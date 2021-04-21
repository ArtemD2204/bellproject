package ru.artemdikov.bellproject.organization.dto;

import ru.artemdikov.bellproject.validation.group.Default;
import ru.artemdikov.bellproject.validation.group.OnCreate;
import ru.artemdikov.bellproject.validation.group.OnUpdate;

import javax.validation.constraints.*;

/**
 * DTO класс для организации
 */
public class OrgDto {

    /**
     * Идентификатор
     */
    @Null(groups = OnCreate.class)
    @Min(value = 1, message = "id should not be less than 1", groups = OnUpdate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    /**
     * Название
     */
    @Size(max = 150, groups = Default.class)
    @NotEmpty(message = "name cannot be empty", groups = Default.class)
    private String name;

    /**
     * Полное название
     */
    @Size(max = 255, groups = Default.class)
    @NotEmpty(message = "fullName cannot be empty", groups = Default.class)
    private String fullName;

    /**
     * ИНН
     */
    @Size(max = 20, groups = Default.class)
    @NotEmpty(message = "inn cannot be empty", groups = Default.class)
    private String inn;

    /**
     * КПП
     */
    @Size(max = 20, groups = Default.class)
    @NotEmpty(message = "kpp cannot be empty", groups = Default.class)
    private String kpp;

    /**
     * Адрес
     */
    @Size(max = 255, groups = Default.class)
    @NotEmpty(message = "address cannot be empty", groups = Default.class)
    private String address;

    /**
     * Телефон
     */
    @Size(max = 30, groups = Default.class)
    private String phone;

    /**
     * Активный
     */
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
