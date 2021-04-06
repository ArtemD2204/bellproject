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
}
