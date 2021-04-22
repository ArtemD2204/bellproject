package ru.artemdikov.bellproject.dictionary.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.dictionary.country.dto.CountryDto;
import ru.artemdikov.bellproject.dictionary.country.model.Country;
import ru.artemdikov.bellproject.dictionary.country.repository.CountryRepository;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, MapperFacade mapperFacade) {
        this.countryRepository = countryRepository;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<CountryDto> countries() {
        List<Country> all = countryRepository.findAll();
        return mapperFacade.mapAsList(all, CountryDto.class);
    }
}
