package ru.artemdikov.bellproject.dictionary.doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.dictionary.doc.repository.DocTypeRepository;
import ru.artemdikov.bellproject.dictionary.doc.dto.DocumentTypeDto;
import ru.artemdikov.bellproject.dictionary.doc.model.DocumentType;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class DocTypeServiceImpl implements DocTypeService {

    private final DocTypeRepository repository;
    private final MapperFacade mapperFacade;

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
