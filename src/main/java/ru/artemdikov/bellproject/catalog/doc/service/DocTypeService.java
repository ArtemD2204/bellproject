package ru.artemdikov.bellproject.catalog.doc.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.catalog.doc.dto.DocumentTypeDto;

import java.util.List;

/**
 * Сервис
 */
@Validated
public interface DocTypeService {

    /**
     * Получить список видов документов
     *
     * @return List{@DocumentTypeDto}
     */
    List<DocumentTypeDto> docTypes();

}
