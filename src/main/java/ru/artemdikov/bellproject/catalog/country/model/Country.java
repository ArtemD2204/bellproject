package ru.artemdikov.bellproject.catalog.country.model;


import javax.persistence.*;

/**
 * Страна
 */
@Entity
@Table(name = "Country")
public class Country {

    /**
     * Код
     */
    @Id
    @Column(name = "code", columnDefinition = "CHAR(3)")
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
