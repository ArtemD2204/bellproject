package ru.artemdikov.bellproject.organization.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.organization.dto.OrgDto;
import ru.artemdikov.bellproject.organization.dto.OrgDtoShort;
import ru.artemdikov.bellproject.organization.dto.OrgFilter;
import ru.artemdikov.bellproject.validation.group.Default;
import ru.artemdikov.bellproject.validation.group.OnCreate;
import ru.artemdikov.bellproject.validation.group.OnUpdate;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис Organization
 */
@Validated
public interface OrganizationService {

    /**
     * Получить все организации
     *
     * @return возвращает список всех организаций
     */
    List<OrgDto> allOrganizations();

    /**
     * Получить отфильтрованный список организаций
     * @param orgFilter - фильтр организаций
     * @return возвращает отфильтрованный список организаций
     */
    List<OrgDtoShort> getFilteredOrganizationList(@Valid OrgFilter orgFilter);

    /**
     * Получить Organization по id
     * @param id - идентификатор
     * @return возвращает организацию
     */
    OrgDto getById(Long id);

    /**
     * Добавить новую организацию
     *
     * @param orgDto - организация
     */
    @Validated({OnCreate.class, Default.class})
    void add(@Valid OrgDto orgDto);

    /**
     * Обновить организацию
     *
     * @param orgDto - организация
     */
    @Validated({OnUpdate.class, Default.class})
    void update(@Valid OrgDto orgDto);

}
