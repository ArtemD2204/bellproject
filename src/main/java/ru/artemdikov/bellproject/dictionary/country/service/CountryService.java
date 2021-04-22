package ru.artemdikov.bellproject.dictionary.country.service;

import ru.artemdikov.bellproject.dictionary.country.dto.CountryDto;

import java.util.List;

/**
 * Сервис для работы с Country
 */
public interface CountryService {

    /**
     * Получить список всех стран
     * @return возвращает список стран
     */
    List<CountryDto> countries();

}
