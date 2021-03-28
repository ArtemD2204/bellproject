package ru.artemdikov.bellproject.catalog.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.catalog.country.dto.CountryDto;
import ru.artemdikov.bellproject.catalog.country.model.Country;
import ru.artemdikov.bellproject.catalog.country.repository.CountryRepository;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Country getModelById(String code) {
        return countryRepository.findByCode(code);
    }

}
