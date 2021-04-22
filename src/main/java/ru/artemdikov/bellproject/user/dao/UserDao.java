package ru.artemdikov.bellproject.user.dao;

import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.user.model.User;

import java.util.List;

/**
 * DAO для работы с User
 */
public interface UserDao {
    /**
     * Получить все объекты User
     *
     * @return возвращает всех пользователей
     */
    List<User> all();

    /**
     * Получить User по идентификатору
     *
     * @param id - идентификатор
     * @return возвращает пользователя
     */
    User loadById(Long id);

    /**
     * Получить отфильтрованный список объектов User
     *
     * @param userFilter - фильтр пользователей
     * @return возвращает отфильтрованный список пользователей
     */
    List<User> loadByFilter(UserFilter userFilter);

    /**
     * Сохранить новый User
     *
     * @param user
     */
    void save(User user);

    /**
     * Обновить User
     *
     * @param user
     */
    void update(User user);
}
