package ru.artemdikov.bellproject.catalog.country.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.catalog.country.dto.CountryDto;
import ru.artemdikov.bellproject.catalog.country.model.Country;

import java.util.List;

/**
 * Сервис
 */
@Validated
public interface CountryService {

    /**
     * Получить список офисов
     *
     * @return {@CountryDto}
     */
    List<CountryDto> countries();

    /**
     * Получить Country model по code
     *
     * @param code
     * @return {@Country}
     */
    Country getModelById(String code);
}
