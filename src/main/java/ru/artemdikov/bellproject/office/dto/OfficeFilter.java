package ru.artemdikov.bellproject.office.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Фильтр для Office
 */
public class OfficeFilter {

    /**
     * id организации
     */
    @NotNull(message = "orgId can not be null")
    private Long orgId;

    /**
     * Название
     */
    @Size(max = 150)
    private String name;

    /**
     * Телефон
     */
    @Size(max = 30)
    private String phone;

    /**
     * Активный
     */
    private Boolean isActive;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
