package ru.artemdikov.bellproject.catalog.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemdikov.bellproject.catalog.country.model.Country;
import ru.artemdikov.bellproject.catalog.doc.model.DocumentType;

import java.util.List;

/**
 * DAO для работы с DocumentType
 */
public interface CountryRepository extends JpaRepository<Country, String> {
    /**
     * Получить все объекты Country
     *
     * @return
     */
    List<Country> findAll();

    /**
     * Получить Country по коду
     *
     * @param code
     * @return
     */
    Country findByCode(String code);

    /**
     * Сохранить Country
     *
     * @param country
     */
    Country save (Country country);
}
