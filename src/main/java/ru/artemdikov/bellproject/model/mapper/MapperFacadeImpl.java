package ru.artemdikov.bellproject.model.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemdikov.bellproject.office.dto.OfficeDto;
import ru.artemdikov.bellproject.office.model.Office;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.model.User;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class MapperFacadeImpl implements MapperFacade {
    private final MapperFactory mapperFactory;

    @Autowired
    public MapperFacadeImpl(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().map(sourceObject, destinationClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, D> void map(S sourceObject, D destinationObject) {
        mapperFactory.getMapperFacade().map(sourceObject, destinationObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().mapAsList(source, destinationClass);
    }

    @PostConstruct
    private void registerMappedClasses() {
        registerUser();
        registerOffice();
    }

    private void registerUser() {
        mapperFactory.classMap(User.class, UserDto.class)
                .field("office.id", "officeId")
                .field("country.code", "citizenshipCode")
                .field("country.name", "citizenshipName")
                .field("document.documentType.code", "docCode")
                .field("document.documentType.name", "docName")
                .field("document.docNumber", "docNumber")
                .field("document.docDate", "docDate")
                .byDefault()
                .register();
    }

    private void registerOffice() {
        mapperFactory.classMap(Office.class, OfficeDto.class)
                .field("organization.id", "orgId")
                .byDefault()
                .register();
    }
}
