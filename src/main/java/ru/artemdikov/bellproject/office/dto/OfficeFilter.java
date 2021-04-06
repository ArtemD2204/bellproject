package ru.artemdikov.bellproject.office.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeFilter {
    @NotNull(message = "organizationId can not be null")
    private Long orgId;

    @Size(max = 150)
    private String name;

    @Size(max = 30)
    private String phone;

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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
