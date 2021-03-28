package ru.artemdikov.bellproject.catalog.doc.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.catalog.doc.dto.DocumentTypeDto;
import ru.artemdikov.bellproject.catalog.doc.model.DocumentType;

import java.util.List;

/**
 * Сервис
 */
@Validated
public interface DocTypeService {

    /**
     * Получить список офисов
     *
     * @return {@DocumentTypeDto}
     */
    List<DocumentTypeDto> docTypes();

    /**
     * Получить DocType model по code
     *
     * @param code
     * @return {@DocumentType}
     */
    DocumentType getModelByCode(String code);
}
