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
 * Сервис
 */
@Validated
public interface OrganizationService {

    /**
     * Получить список организаций
     *
     * @return {@OrgDto}
     */
    List<OrgDto> allOrganizations();

    /**
     * Получить отфильтрованный список организаций
     *
     * @return {@List<OrgDtoShort>}
     */
    List<OrgDtoShort> getFilteredOrganizationList(@Valid OrgFilter orgFilter);

    /**
     * Получить Organization по id
     *
     * @return {OrgDto}
     */
    OrgDto getById(Long id);

    /**
     * Добавить новую организацию в БД
     *
     * @param orgDto
     */
    @Validated({OnCreate.class, Default.class})
    void add(@Valid OrgDto orgDto);

    /**
     * Обновить организацию в БД
     *
     * @param orgDto
     */
    @Validated({OnUpdate.class, Default.class})
    void update(@Valid OrgDto orgDto);

}
