package ru.artemdikov.bellproject.model.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemdikov.bellproject.catalog.country.repository.CountryRepository;
import ru.artemdikov.bellproject.catalog.doc.repository.DocTypeRepository;
import ru.artemdikov.bellproject.document.model.Document;
import ru.artemdikov.bellproject.office.dao.OfficeDao;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.model.User;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class MapperFacadeImpl implements MapperFacade {
    private final MapperFactory mapperFactory;
    private final OfficeDao officeDao;
    private final CountryRepository countryRepository;
    private final DocTypeRepository docTypeRepository;

    @Autowired
    public MapperFacadeImpl(MapperFactory mapperFactory, OfficeDao officeDao, CountryRepository countryRepository,
                            DocTypeRepository docTypeRepository) {
        this.mapperFactory = mapperFactory;
        this.officeDao = officeDao;
        this.countryRepository = countryRepository;
        this.docTypeRepository = docTypeRepository;
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
    }

    private void registerUser() {
        Type<User> userType = TypeFactory.valueOf(User.class);
        mapperFactory.registerObjectFactory(new ObjectFactory<User>() {
            @Override
            public User create(Object o, MappingContext mappingContext) {
                UserDto userDto = (UserDto) o;
                User user = new User();
                String docCode = userDto.getDocCode();
                String docNumber = userDto.getDocNumber();
                String docDate = userDto.getDocDate();
                if(docCode != null && docNumber != null && docDate != null) {
                    Document document = new Document();
                    document.setDocumentType(docTypeRepository.findByCode(docCode));
                    document.setDocNumber(docNumber);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        document.setDocDate(dateFormat.parse(docDate));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    user.setDocument(document);
                    document.setUser(user);
                }
                user.setOffice(officeDao.loadById(userDto.getOfficeId()));
                String citizenshipCode = userDto.getCitizenshipCode();
                if (citizenshipCode != null) {
                    user.setCountry(countryRepository.findByCode(citizenshipCode));
                }
                return user;
            }
        }, userType);

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
