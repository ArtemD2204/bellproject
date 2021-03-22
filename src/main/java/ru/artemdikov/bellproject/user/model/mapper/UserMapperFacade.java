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
    private final CustomMapper<User, UserDto> userCustomMapper;

    @Autowired
    public UserMapperFacade(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        this.userCustomMapper = new CustomMapper<User, UserDto>() {
            @Override
            public void mapAtoB(User user, UserDto userDto, MappingContext context) {
//                userDto.setOfficeId(user.getOffice().getId());
                Document document = user.getDocument();
                if (document != null) {
                    userDto.setDocDate(dateFormat.format(document.getDocDate()));
//                    userDto.setDocNumber(document.getDocNumber());
//                    DocumentType documentType = document.getDocumentType();
//                    if (documentType != null) {
//                        userDto.setDocCode(documentType.getCode());
//                        userDto.setD
//                    }
                }
            }

            @Override
            public void mapBtoA(UserDto userDto, User user, MappingContext context) {

            }
        };
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
        mapperFactory.classMap(User.class, UserDto.class).customize(userCustomMapper).field("office.id", "officeId").byDefault().register();
    }
}
