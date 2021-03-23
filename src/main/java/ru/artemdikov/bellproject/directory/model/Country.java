package ru.artemdikov.bellproject.directory.model;


import javax.persistence.*;

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
     * Название
     */
    @Column(name = "name", length = 150, nullable = false)
    private String name;

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
