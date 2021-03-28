package ru.artemdikov.bellproject.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.catalog.country.repository.CountryRepository;
import ru.artemdikov.bellproject.catalog.doc.repository.DocTypeRepository;
import ru.artemdikov.bellproject.document.model.Document;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;
import ru.artemdikov.bellproject.office.dao.OfficeDao;
import ru.artemdikov.bellproject.user.dao.UserDao;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.model.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;
    private final MapperFacade mapperFacade;
    private final OfficeDao officeDao;
    private final CountryRepository countryRepository;
    private final DocTypeRepository docTypeRepository;

    @Autowired
    public UserServiceImpl(UserDao dao, MapperFacade mapperFacade, OfficeDao officeDao,
                           CountryRepository countryRepository, DocTypeRepository docTypeRepository) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
        this.officeDao = officeDao;
        this.countryRepository = countryRepository;
        this.docTypeRepository = docTypeRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserDto> allUsers() {
        List<User> all = dao.all();
        return mapperFacade.mapAsList(all, UserDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public UserDto getById(Long id) {
        User user = dao.loadById(id);
        return mapperFacade.map(user, UserDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(UserDto dto) {
        User user = new User();
        mapDtoToModel(dto, user);
        dao.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(UserDto dto) {
        User user = dao.loadById(dto.getId());
        mapDtoToModel(dto, user);
//        dao.update(user); // не нужно
    }

    private void mapDtoToModel(UserDto userDto, User user) {
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setMiddleName(userDto.getMiddleName());
        user.setPhone(userDto.getPhone());
        user.setPosition(userDto.getPosition());
        user.setIdentified(userDto.getIdentified());
        user.setOffice(officeDao.loadProxyById(userDto.getOfficeId()));
        String citizenshipCode = userDto.getCitizenshipCode();
        if (citizenshipCode != null) {
            user.setCountry(countryRepository.getOne(citizenshipCode));
        } else {
            user.setCountry(null);
        }
        Document document;
        if (user.getId() == null) { // если новый user
            document = new Document();
        } else {
            document = user.getDocument();
        }
        updateDocument(document, userDto.getDocCode(), userDto.getDocNumber(), userDto.getDocDate());
        user.addDocument(document);
    }

    private void updateDocument(Document document, String docCode, String docNumber, String docDate) {
        document.setDocumentType(docTypeRepository.getOne(docCode));
        document.setDocNumber(docNumber);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            document.setDocDate(dateFormat.parse(docDate));
        } catch (ParseException e) {
            throw new RuntimeException("userDto.docDate to user.document.docDate mapping error", e);
        }
    }

}
