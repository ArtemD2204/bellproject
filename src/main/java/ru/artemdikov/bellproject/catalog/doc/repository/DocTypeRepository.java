package ru.artemdikov.bellproject.catalog.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemdikov.bellproject.catalog.doc.model.DocumentType;

import java.util.List;

/**
 * DAO для работы с DocumentType
 */
public interface DocTypeRepository extends JpaRepository<DocumentType, String> {
    /**
     * Получить все объекты DocumentType
     *
     * @return
     */
    List<DocumentType> findAll();

    /**
     * Получить DocumentType по коду
     *
     * @param code
     * @return
     */
    DocumentType findByCode(String code);

    /**
     * Сохранить DocumentType
     *
     * @param documentType
     */
    DocumentType save (DocumentType documentType);
}
