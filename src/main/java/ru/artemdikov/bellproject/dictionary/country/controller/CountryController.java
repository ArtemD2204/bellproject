package ru.artemdikov.bellproject.dictionary.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.artemdikov.bellproject.dictionary.country.dto.CountryDto;
import ru.artemdikov.bellproject.dictionary.country.service.CountryService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для работы со справочником стран
 * @author Artem Dikov
 */
@RestController
@RequestMapping(value = "/api/countries", produces = APPLICATION_JSON_VALUE)
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Вернуть список всех стран
     * @return возвращает список всех стран
     */
    @GetMapping("")
    public List<CountryDto> allCountries() {
        return countryService.countries();
    }
}
