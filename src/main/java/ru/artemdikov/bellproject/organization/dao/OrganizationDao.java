package ru.artemdikov.bellproject.organization.dao;

import ru.artemdikov.bellproject.organization.dto.OrgFilter;
import ru.artemdikov.bellproject.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);

    /**
     * Получить отфильтрованный список объектов Organization
     *
     * @param orgFilter
     * @return
     */
    List<Organization> loadByFilter(OrgFilter orgFilter);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);

    /**
     * Обновить Organization
     *
     * @param organization
     */
    void update(Organization organization);
}
