package ru.artemdikov.bellproject.document.model;

import ru.artemdikov.bellproject.directory.model.DocumentType;
import ru.artemdikov.bellproject.user.model.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Документ
 */
@Entity
@Table(name = "Document")
public class Document {

    @Id
    @Column(name = "Id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Номер документа
     */
    @Column(name = "doc_number", length = 30, nullable = false)
    private String docNumber;

    /**
     * Дата документа
     */
    @Column(name = "doc_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date docDate;

    /**
     * Тип документа
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_code", referencedColumnName = "code")
    private DocumentType documentType;

    /**
     * Пользователь
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @MapsId
    private User user;

    public Long getId() {
        return id;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
