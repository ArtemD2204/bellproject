package ru.artemdikov.bellproject.organization.model;

import ru.artemdikov.bellproject.office.model.Office;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Оранизация
 */
@Entity
@Table(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Название
     */
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    /**
     * Полное название
     */
    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", length = 20, nullable = false)
    private String inn;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 20, nullable = false)
    private String kpp;

    /**
     * Адрес
     */
    @Column(name = "address", length = 255, nullable = false)
    private String address;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 30, nullable = false)
    private String phone;

    /**
     * boolean
     */
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    /**
     * Офисы
     */
    @OneToMany(mappedBy = "organization")
    private Set<Office> offices;

    public Long getId() {
        return id;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<Office> getOffices() {
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
