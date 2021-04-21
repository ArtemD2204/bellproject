package ru.artemdikov.bellproject.catalog.country.service;

import ru.artemdikov.bellproject.catalog.country.dto.CountryDto;

import java.util.List;

/**
 * Сервис для работы с Country
 */
public interface CountryService {

    /**
     * Получить список всех стран
     * @return список стран
     */
    List<CountryDto> countries();

}
