package ru.artemdikov.bellproject.office.dao;

import ru.artemdikov.bellproject.office.model.Office;
import ru.artemdikov.bellproject.user.model.User;

import java.util.List;
import java.util.Map;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {
    /**
     * Получить все объекты Office
     *
     * @return
     */
    List<Office> all();

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    Office loadById(Long id);

    /**
     * Получить Office proxy по идентификатору
     *
     * @param id
     * @return
     */
    Office loadProxyById(Long id);

    /**
     * Получить Office по имени
     *
     * @param name
     * @return
     */
//    Office loadByName(String name);

    /**
     * Получить отфильтрованный список объектов Office
     *
     * @param filters
     * @return
     */
    List<Office> loadByFilter(Map<String, String> filters);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void save(Office office);
}
