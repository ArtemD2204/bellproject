package ru.artemdikov.bellproject.office.dao;

import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.office.model.Office;
import ru.artemdikov.bellproject.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {
    /**
     * Получить все объекты Office
     *
     * @return возвращает список всех офисов
     */
    List<Office> all();

    /**
     * Получить Office по идентификатору
     *
     * @param id - идентификатор
     * @return офис
     */
    Office loadById(Long id);

    /**
     * Получить Office proxy по идентификатору. Ленивая инициализация
     *
     * @param id - идентификатор
     * @return Office proxy
     */
    Office loadProxyById(Long id);

    /**
     * Получить отфильтрованный список объектов Office
     *
     * @param officeFilter - фильтры
     * @return возвращает отфильтрованный список офисов
     */
    List<Office> loadByFilter(OfficeFilter officeFilter);

    /**
     * Сохранить Office
     *
     * @param office - офис
     */
    void save(Office office);

    /**
     * Обновить Office
     *
     * @param office - офис
     */
    public void update(Office office);
}
