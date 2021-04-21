package ru.artemdikov.bellproject.catalog.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemdikov.bellproject.catalog.country.model.Country;

import java.util.List;

/**
 * Repository для работы со справочником стран
 */
public interface CountryRepository extends JpaRepository<Country, String> {
    /**
     * Получить все объекты Country
     * @return список всех стран
     */
    List<Country> findAll();
}
