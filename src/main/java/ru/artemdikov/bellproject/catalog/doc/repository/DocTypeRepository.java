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
     * @return возвращает все виды документов
     */
    List<DocumentType> findAll();

    /**
     * Получить объект DocumentType по имени
     * @param name - название вида документа
     * @return возвращает вид документа
     */
    DocumentType findByName(String name);

    /**
     * Получить объект DocumentType по коду и имени
     * @param code - код вида документа
     * @param name - название вида документа
     * @return возвращает вид документа
     */
    DocumentType findByCodeAndName(String code, String name);
}
