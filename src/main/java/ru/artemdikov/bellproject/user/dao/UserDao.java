package ru.artemdikov.bellproject.user.dao;

import ru.artemdikov.bellproject.user.model.User;

import java.util.List;
import java.util.Map;

/**
 * DAO для работы с User
 */
public interface UserDao {
    /**
     * Получить все объекты User
     *
     * @return
     */
    List<User> all();

    /**
     * Получить User по идентификатору
     *
     * @param id
     * @return
     */
    User loadById(Long id);

    /**
     * Получить отфильтрованный список объектов User
     *
     * @param filters
     * @return
     */
    List<User> loadByFilter(Map<String, String> filters);

    /**
     * Сохранить User
     *
     * @param user
     */
    void save(User user);

    /**
     * Обновить User
     *
     * @param user
     */
    public void update(User user);
}
