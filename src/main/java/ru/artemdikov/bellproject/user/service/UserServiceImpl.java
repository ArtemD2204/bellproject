package ru.artemdikov.bellproject.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.catalog.country.model.Country;
import ru.artemdikov.bellproject.catalog.country.repository.CountryRepository;
import ru.artemdikov.bellproject.catalog.doc.model.DocumentType;
import ru.artemdikov.bellproject.catalog.doc.repository.DocTypeRepository;
import ru.artemdikov.bellproject.document.model.Document;
import ru.artemdikov.bellproject.exception.EntityNotFoundException;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;
import ru.artemdikov.bellproject.office.dao.OfficeDao;
import ru.artemdikov.bellproject.office.model.Office;
import ru.artemdikov.bellproject.user.dao.UserDao;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.dto.UserDtoShort;
import ru.artemdikov.bellproject.user.dto.UserFilter;
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

    /**
     * Конструктор
     * @param dao
     * @param mapperFacade
     * @param officeDao
     * @param countryRepository
     * @param docTypeRepository
     */
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
        if (all.size() == 0) {
            throw new EntityNotFoundException("No users in database.");
        }
        return mapperFacade.mapAsList(all, UserDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserDtoShort> filteredUserList(UserFilter userFilter) {
        List<User> userList = dao.loadByFilter(userFilter);
        if (userList.size() == 0) {
            throw new EntityNotFoundException("No users were found. Please, change filters parameters.");
        }
        return mapperFacade.mapAsList(userList, UserDtoShort.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public UserDto getById(Long id) {
        User user = dao.loadById(id);
        if (user == null) {
            throw new EntityNotFoundException("User not found for id=" + id + ".");
        }
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
        dao.update(user);
    }

    private void mapDtoToModel(UserDto userDto, User user) {
        if (userDto.getFirstName() != null && !userDto.getFirstName().isEmpty()) {
            user.setFirstName(userDto.getFirstName());
        }
        if (userDto.getSecondName() != null && !userDto.getSecondName().isEmpty()) {
            user.setSecondName(userDto.getSecondName());
        }
        if (userDto.getMiddleName() != null && !userDto.getMiddleName().isEmpty()) {
            user.setMiddleName(userDto.getMiddleName());
        }
        if (userDto.getPhone() != null && !userDto.getPhone().isEmpty()) {
            user.setPhone(userDto.getPhone());
        }
        if (userDto.getPosition() != null && !userDto.getPosition().isEmpty()) {
            user.setPosition(userDto.getPosition());
        }
        if (userDto.getIdentified() != null) {
            user.setIdentified(userDto.getIdentified());
        }
        mapOffice(userDto, user);
        mapCountry(userDto, user);
        Document document;
        if (user.getId() == null) { // если новый user
            document = new Document();
            user.addDocument(document);
        } else {
            document = user.getDocument();
        }
        updateDocument(userDto, document);
    }

    private void mapOffice(UserDto userDto, User user) {
        if (userDto.getOfficeId() != null) {
            Office office = officeDao.loadById(userDto.getOfficeId());
            if (office == null) {
                throw new EntityNotFoundException("Office not found for id=" + userDto.getOfficeId() + ".");
            }
            user.setOffice(office);
        }
    }

    private void mapCountry(UserDto userDto, User user) {
        if (userDto.getCitizenshipCode() != null) {
            Country country = countryRepository.findById(userDto.getCitizenshipCode()).orElse(null);
            if (country == null) {
                throw new EntityNotFoundException("Country not found for citizenshipCode="
                        + userDto.getCitizenshipCode() + ".");
            }
            user.setCountry(country);
        }
    }

    private void updateDocument(UserDto userDto, Document document) {
        DocumentType documentType;
        String docCode = userDto.getDocCode();
        String docName = userDto.getDocName();
        if (docCode != null && docName != null) {
            documentType = docTypeRepository.findByCodeAndName(docCode, docName);
            if (documentType == null) {
                throw new EntityNotFoundException("DocumentType not found for docCode=" + docCode
                        + " and docName=" + docName + ".");
            }
            document.setDocumentType(documentType);
        } else if (docCode != null) {
            documentType = docTypeRepository.findById(docCode).orElse(null);
            if (documentType == null) {
                throw new EntityNotFoundException("DocumentType not found for docCode=" + docCode + ".");
            }
            document.setDocumentType(documentType);
        } else if (docName != null) {
            documentType = docTypeRepository.findByName(docName);
            if (documentType == null) {
                throw new EntityNotFoundException("DocumentType not found for docName=" + docName + ".");
            }
            document.setDocumentType(documentType);
        }
        if (userDto.getDocNumber() != null && !userDto.getDocNumber().isEmpty()) {
            document.setDocNumber(userDto.getDocNumber());
        }
        if (userDto.getDocDate() != null && !userDto.getDocDate().isEmpty()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                document.setDocDate(dateFormat.parse(userDto.getDocDate()));
            } catch (ParseException e) {
                throw new RuntimeException("userDto.docDate to user.document.docDate mapping error", e);
            }
        }
    }
}
