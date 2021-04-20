package ru.artemdikov.bellproject.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.artemdikov.bellproject.organization.dto.OrgDto;
import ru.artemdikov.bellproject.organization.dto.OrgDtoShort;
import ru.artemdikov.bellproject.organization.dto.OrgFilter;
import ru.artemdikov.bellproject.organization.service.OrganizationService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/save")
    public void saveOffice(@RequestBody OrgDto organization) {
        organizationService.add(organization);
    }

    @PostMapping("/update")
    public void updateOffice(@RequestBody OrgDto organization) {
        organizationService.update(organization);
    }

    @GetMapping("/all")
    public List<OrgDto> allOffices() {
        return organizationService.allOrganizations();
    }

    @GetMapping("/{id}")
    public OrgDto office(@PathVariable Long id) {
        return organizationService.getById(id);
    }

    @PostMapping("/list")
    public List<OrgDtoShort> list(@RequestBody OrgFilter orgFilter) {
        return organizationService.getFilteredOrganizationList(orgFilter);
    }
}
