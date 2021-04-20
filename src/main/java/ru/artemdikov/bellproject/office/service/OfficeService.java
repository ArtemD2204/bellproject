package ru.artemdikov.bellproject.office.service;

import org.springframework.validation.annotation.Validated;
import ru.artemdikov.bellproject.office.dto.OfficeDto;
import ru.artemdikov.bellproject.office.dto.OfficeDtoShort;
import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.validation.group.Default;
import ru.artemdikov.bellproject.validation.group.OnCreate;
import ru.artemdikov.bellproject.validation.group.OnUpdate;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface OfficeService {

    /**
     * Получить список офисов
     *
     * @return {@OfficeDto}
     */
    List<OfficeDto> allOffices();

    /**
     * Получить отфильтрованный список офисов
     *
     * @return {@List<OfficeDtoShort>}
     */
    List<OfficeDtoShort> getFilteredOfficeList(@Valid OfficeFilter officeFilter);

    /**
     * Получить Office по id
     *
     * @return {OfficeDto}
     */
    OfficeDto getById(Long id);

    /**
     * Добавить новый офис в БД
     *
     * @param officeDto
     */
    @Validated({OnCreate.class, Default.class})
    void add(@Valid OfficeDto officeDto);

    /**
     * Обновить офис в БД
     *
     * @param officeDto
     */
    @Validated({OnUpdate.class, Default.class})
    void update(@Valid OfficeDto officeDto);

}
