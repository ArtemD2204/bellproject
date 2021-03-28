package ru.artemdikov.bellproject.office.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.office.dto.OfficeDto;
import ru.artemdikov.bellproject.office.model.Office;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface OfficeService {

    /**
     * Добавить новый офис в БД
     *
     * @param officeDto
     */
    void add(@Valid OfficeDto officeDto);

    /**
     * Получить список офисов
     *
     * @return {@OfficeDto}
     */
    List<OfficeDto> offices();

    /**
     * Получить Office model по id
     *
     * @param id
     * @return {@Office}
     */
    Office getModelById(Long id);
}
