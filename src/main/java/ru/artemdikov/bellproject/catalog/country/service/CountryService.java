package ru.artemdikov.bellproject.catalog.country.service;

import ru.artemdikov.bellproject.catalog.country.dto.CountryDto;

import java.util.List;

/**
 * Сервис
 */

public interface CountryService {

    /**
     * Получить список стран
     *
     * @return {@CountryDto}
     */
    List<CountryDto> countries();

}
