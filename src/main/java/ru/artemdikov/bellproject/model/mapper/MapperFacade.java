package ru.artemdikov.bellproject.model.mapper;

import ma.glasnost.orika.CustomMapper;

import java.util.List;

/**
 * Фасад для преобразования между можелями БД и фронта
 *
 * @param <M> тип model объекта
 * @param <D> тип dto объекта
 */
public interface MapperFacade<M, D> {

    /**
     * Преобразование sourceObject в экземпляр класса destinationClass
     *
     * @param sourceObject     исходный объект
     * @param destinationClass класс, в который надо преобразовать объект
     * @param <M>              тип исходного объекта
     * @param <D>              тип объекта, к который надо преобразовать исходный объект
     * @return экземпляр класса D с данными из sourceObject
     */
    D toDto(M model);

    M toModel(D dto);

    /**
     * Запись занных из sourceObject в destinationObject
     *
     * @param sourceObject
     * @param destinationObject
     * @param <S>
     * @param <D>
     */
    void toDto(M model, D dto);

    void toModel(D dto, M model);

    /**
     * Преобразование коллекции оъектов
     *
     * @param source
     * @param destinationClass
     * @param <S>
     * @param <D>
     * @return
     */
    List<D> mapAsListToDto(Iterable<M> source);

    List<M> mapAsListToModel(Iterable<D> source);
}
