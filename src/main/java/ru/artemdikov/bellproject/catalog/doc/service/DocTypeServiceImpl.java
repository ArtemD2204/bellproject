package ru.artemdikov.bellproject.catalog.doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.catalog.doc.repository.DocTypeRepository;
import ru.artemdikov.bellproject.catalog.doc.dto.DocumentTypeDto;
import ru.artemdikov.bellproject.catalog.doc.model.DocumentType;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class DocTypeServiceImpl implements DocTypeService {

    private final DocTypeRepository repository;
    private final MapperFacade mapperFacade;

    /**
     * Конструктор - создание нового объекта сервиса
     * @param repository - repository для работы с DocumentType
     * @param mapperFacade - mapper для преобразования DocumentType в DocumentTypeDto
     */
    @Autowired
    public DocTypeServiceImpl(DocTypeRepository repository, MapperFacade mapperFacade) {
        this.repository = repository;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<DocumentTypeDto> docTypes() {
        List<DocumentType> all = repository.findAll();
        return mapperFacade.mapAsList(all, DocumentTypeDto.class);
    }

}
