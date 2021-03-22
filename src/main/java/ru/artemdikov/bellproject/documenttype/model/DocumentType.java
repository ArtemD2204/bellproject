package ru.artemdikov.bellproject.documenttype.model;

import ru.artemdikov.bellproject.document.model.Document;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Вид документа
 */
@Entity
@Table(name = "Document_Type")
public class DocumentType {
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
    @OneToMany(mappedBy = "documentType")
    private Set<Document> documents;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Document> getDocuments() {
        if (documents == null) {
            documents = new HashSet<>();
        }
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}
