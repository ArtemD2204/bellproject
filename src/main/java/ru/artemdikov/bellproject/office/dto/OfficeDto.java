package ru.artemdikov.bellproject.office.dto;

import ru.artemdikov.bellproject.validation.group.Default;
import ru.artemdikov.bellproject.validation.group.OnCreate;
import ru.artemdikov.bellproject.validation.group.OnUpdate;

import javax.validation.constraints.*;

public class OfficeDto {

    @Null(groups = OnCreate.class)
    @Min(value = 1, message = "id should not be less than 1", groups = OnUpdate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    @Size(max = 150, groups = Default.class)
    @NotEmpty(message = "name cannot be null", groups = OnUpdate.class)
    private String name;

    @Size(max = 255, groups = Default.class)
    @NotEmpty(message = "address cannot be null", groups = OnUpdate.class)
    private String address;

    @Size(max = 30, groups = Default.class)
    private String phone;

    private Boolean isActive;

    @NotNull(message = "orgId can not be null", groups = OnCreate.class)
    @Null(message = "orgId can not be changed", groups = OnUpdate.class)
    private Long orgId;

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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long organizationId) {
        this.orgId = organizationId;
    }
}
