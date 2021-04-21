package ru.artemdikov.bellproject.catalog.doc.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.catalog.doc.dto.DocumentTypeDto;

import java.util.List;

/**
 * Сервис для работы с DocumentType
 */
@Validated
public interface DocTypeService {

    /**
     * Получить список видов документов
     * @return возвращает все виды документов
     */
    List<DocumentTypeDto> docTypes();

}
