package ru.artemdikov.bellproject.user.model.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemdikov.bellproject.document.model.Document;
import ru.artemdikov.bellproject.directory.model.DocumentType;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * {@inheritDoc}
 */
@Service
public class UserMapperFacade implements MapperFacade<User, UserDto> {
    private final MapperFactory mapperFactory;

    @Autowired
    public UserMapperFacade(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto toDto(User model) {
        configure();
        return mapperFactory.getMapperFacade().map(model, UserDto.class);
    }

    @Override
    public User toModel(UserDto dto) {
        return null;
    }

    @Override
    public void toDto(User model, UserDto dto) {
        configure();
        mapperFactory.getMapperFacade().map(model, dto);
    }

    @Override
    public void toModel(UserDto dto, User model) {

    }

    @Override
    public List<UserDto> mapAsListToDto(Iterable<User> source) {
        configure();
        return mapperFactory.getMapperFacade().mapAsList(source, UserDto.class);
    }

    @Override
    public List<User> mapAsListToModel(Iterable<UserDto> source) {
        return null;
    }

    private void configure() {
        mapperFactory.classMap(User.class, UserDto.class)
                .field("office.id", "officeId")
                .field("country.code", "citizenshipCode")
                .field("document.documentType.code", "docCode")
                .field("document.documentType.name", "docName")
                .field("document.docNumber", "docNumber")
                .field("document.docDate", "docDate")
                .byDefault()
                .register();
    }
}
