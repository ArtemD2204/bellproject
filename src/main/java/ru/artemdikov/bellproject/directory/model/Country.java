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
    @Column(name = "code")
    private Integer code;

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
     * Пользователи
     */
    @OneToMany(mappedBy = "country")
    private Set<User> users;
}
