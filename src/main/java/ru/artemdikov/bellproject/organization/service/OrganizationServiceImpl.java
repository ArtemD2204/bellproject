package ru.artemdikov.bellproject.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.exception.EntityNotFoundException;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;
import ru.artemdikov.bellproject.organization.dao.OrganizationDao;
import ru.artemdikov.bellproject.organization.dto.OrgDto;
import ru.artemdikov.bellproject.organization.dto.OrgDtoShort;
import ru.artemdikov.bellproject.organization.dto.OrgFilter;
import ru.artemdikov.bellproject.organization.model.Organization;

import javax.validation.Valid;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(OrgDto dto) {
        Organization organization = mapperFacade.map(dto, Organization.class);
        dao.save(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(OrgDto orgDto) {
        Organization organization = dao.loadById(orgDto.getId());
        if (organization == null) {
            throw new EntityNotFoundException("Organization not found for id=" + orgDto.getId() + ".");
        }
        mapperFacade.map(orgDto, organization);
        dao.update(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrgDto> allOrganizations() {
        List<Organization> all = dao.all();
        if (all.size() == 0) {
            throw new EntityNotFoundException("No organizations in database.");
        }
        return mapperFacade.mapAsList(all, OrgDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrgDtoShort> getFilteredOrganizationList(@Valid OrgFilter orgFilter) {
        List<Organization> organizationList = dao.loadByFilter(orgFilter);
        if (organizationList.size() == 0) {
            throw new EntityNotFoundException("No organizations were found. Please, change filter parameters.");
        }
        return mapperFacade.mapAsList(organizationList, OrgDtoShort.class);
    }

    @Override
    @Transactional(readOnly = true)
    public OrgDto getById(Long id) {
        Organization organization = dao.loadById(id);
        if (organization == null) {
            throw new EntityNotFoundException("Organization not found for id=" + id + ".");
        }
        return mapperFacade.map(organization, OrgDto.class);
    }
}
