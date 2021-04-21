package ru.artemdikov.bellproject.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.exception.EntityNotFoundException;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;
import ru.artemdikov.bellproject.office.dao.OfficeDao;
import ru.artemdikov.bellproject.office.dto.OfficeDto;
import ru.artemdikov.bellproject.office.dto.OfficeDtoShort;
import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.office.model.Office;
import ru.artemdikov.bellproject.organization.dao.OrganizationDao;
import ru.artemdikov.bellproject.organization.model.Organization;

import javax.validation.Valid;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OrganizationDao organizationDao;
    private final OfficeDao dao;
    private final MapperFacade mapperFacade;

    /**
     * Конструктор
     * @param organizationDao
     * @param dao
     * @param mapperFacade
     */
    @Autowired
    public OfficeServiceImpl(OrganizationDao organizationDao, OfficeDao dao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(OfficeDto dto) {
        Office office = new Office();
        Organization organization = organizationDao.loadById(dto.getOrgId());
        if (organization == null) {
            throw new EntityNotFoundException("Organization not found for id=" + dto.getOrgId() + ".");
        }
        office.setOrganization(organization);
        mapDtoToModel(dto, office);
        dao.save(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(@Valid OfficeDto officeDto) {
        Office office = dao.loadById(officeDto.getId());
        if (office == null) {
            throw new EntityNotFoundException("Office not found for id=" + officeDto.getId() + ".");
        }
        mapDtoToModel(officeDto, office);
        dao.update(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeDto> allOffices() {
        List<Office> all = dao.all();
        if (all.size() == 0) {
            throw new EntityNotFoundException("No offices in database.");
        }
        return mapperFacade.mapAsList(all, OfficeDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OfficeDtoShort> getFilteredOfficeList(@Valid OfficeFilter officeFilter) {
        List<Office> officeList = dao.loadByFilter(officeFilter);
        if (officeList.size() == 0) {
            throw new EntityNotFoundException("No offices were found. Please, change filter parameters.");
        }
        return mapperFacade.mapAsList(officeList, OfficeDtoShort.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeDto getById(Long id) {
        Office office = dao.loadById(id);
        if (office == null) {
            throw new EntityNotFoundException("Office not found for id=" + id + ".");
        }
        return mapperFacade.map(office, OfficeDto.class);
    }

    private void mapDtoToModel(OfficeDto dto, Office office) {
        if (dto.getName() != null) {
            office.setName(dto.getName());
        }
        if (dto.getAddress() != null) {
            office.setAddress(dto.getAddress());
        }
        if (dto.getPhone() != null) {
            office.setPhone(dto.getPhone());
        }
        if (dto.getActive() != null) {
            office.setActive(dto.getActive());
        }
    }
}
