package ru.artemdikov.bellproject.organization.dao;

import ru.artemdikov.bellproject.organization.model.Organization;
import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.user.model.User;

import java.util.List;

public interface OrganizationDao {
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
    Organization loadById(Long id);

    /**
     * Получить отфильтрованный список объектов User
     *
     * @param userFilter
     * @return
     */
    List<User> loadByFilter(UserFilter userFilter);

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
