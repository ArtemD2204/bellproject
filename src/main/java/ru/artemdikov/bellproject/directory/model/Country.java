package ru.artemdikov.bellproject.directory.model;

import ru.artemdikov.bellproject.user.model.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "Country")
public class Country {

    /**
     * Код
     */
    @Id
    @Column(name = "code", length = 3)
    private String code;

    /**
     * Служебное поле hibernate
     */
//    @Version
//    private Integer version;

    /**
     * Название
     */
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    /**
     * Пользователи
     */
    @OneToMany(mappedBy = "country")
    private Set<User> users;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
