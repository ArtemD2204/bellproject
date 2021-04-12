package ru.artemdikov.bellproject.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;
import ru.artemdikov.bellproject.office.dao.OfficeDao;
import ru.artemdikov.bellproject.office.dto.OfficeDto;
import ru.artemdikov.bellproject.office.dto.OfficeDtoShort;
import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.office.model.Office;
import ru.artemdikov.bellproject.organization.dao.OrganizationDao;

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
        office.setOrganization(organizationDao.loadById(dto.getOrgId()));
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
        mapDtoToModel(officeDto, office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeDto> allOffices() {
        List<Office> all = dao.all();
        return mapperFacade.mapAsList(all, OfficeDto.class);
    }

    @Override
    @Transactional
    public List<OfficeDtoShort> filteredOfficeList(@Valid OfficeFilter officeFilter) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeDto getById(Long id) {
        Office office = dao.loadById(id);
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
