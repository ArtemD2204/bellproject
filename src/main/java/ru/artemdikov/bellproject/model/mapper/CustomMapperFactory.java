package ru.artemdikov.bellproject.model.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Фабрика для создания MapperFactory.
 * При необходимости можно добавить кастомные мапперы
 */
@Service
public class CustomMapperFactory implements FactoryBean<MapperFactory> {
    /**
     * {@inheritDoc}
     */
    @Override
    public MapperFactory getObject() {
        return new DefaultMapperFactory.Builder()
                .constructorResolverStrategy(null)
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getObjectType() {
        return MapperFactory.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
