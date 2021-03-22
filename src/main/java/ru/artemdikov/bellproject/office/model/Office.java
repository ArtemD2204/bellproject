package ru.artemdikov.bellproject.office.model;

import ru.artemdikov.bellproject.organization.model.Organization;
import ru.artemdikov.bellproject.user.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Офис
 */
@Entity
@Table(name = "Office")
public class Office {

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
     * Пользователи
     */
    @OneToMany(mappedBy = "office")
    private Set<User> users;

    /**
     * Организация
     */
    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    public Long getId() {
        return id;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<User> getUsers() {
        if (users == null) {
            users = new HashSet<>();
        }
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}