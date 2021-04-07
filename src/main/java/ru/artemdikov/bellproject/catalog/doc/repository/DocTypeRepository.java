package ru.artemdikov.bellproject.catalog.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemdikov.bellproject.catalog.doc.model.DocumentType;

import java.util.List;

/**
 * Repository для работы с DocumentType
 */
public interface DocTypeRepository extends JpaRepository<DocumentType, String> {
    /**
     * Получить все объекты DocumentType
     *
     * @return
     */
    List<DocumentType> findAll();

    /**
     * Получить объект DocumentType по имени
     * @param name
     * @return
     */
    DocumentType findByName(String name);

    /**
     * Получить объект DocumentType по коду и имени
     * @param code
     * @param name
     * @return
     */
    DocumentType findByCodeAndName(String code, String name);
}
