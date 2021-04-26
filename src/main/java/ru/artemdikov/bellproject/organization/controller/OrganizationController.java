package ru.artemdikov.bellproject.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.artemdikov.bellproject.organization.dto.OrgDto;
import ru.artemdikov.bellproject.organization.dto.OrgDtoShort;
import ru.artemdikov.bellproject.organization.dto.OrgFilter;
import ru.artemdikov.bellproject.organization.service.OrganizationService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для работы с организациями
 */
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Сохранить новую организацию
     * @param organization
     */
    @PostMapping("/save")
    public void saveOrganization(@RequestBody OrgDto organization) {
        organizationService.add(organization);
    }

    /**
     * Обновить организацию
     * @param organization
     */
    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrgDto organization) {
        organizationService.update(organization);
    }

    /**
     * Получить все организации
     * @return возвращает все организации
     */
    @GetMapping("/all")
    public List<OrgDto> getAllOrganizations() {
        return organizationService.allOrganizations();
    }

    /**
     * Получить организацию по id
     * @param id - идентификатор
     * @return возвращает организацию
     */
    @GetMapping("/{id}")
    public OrgDto getOrganization(@PathVariable Long id) {
        return organizationService.getById(id);
    }

    /**
     * Получить отфильтрованный список организаций
     * @param orgFilter - фильтр организаций
     * @return возвращает отфильтрованный список организаций
     */
    @PostMapping("/list")
    public List<OrgDtoShort> list(@RequestBody OrgFilter orgFilter) {
        return organizationService.getFilteredOrganizationList(orgFilter);
    }
}
