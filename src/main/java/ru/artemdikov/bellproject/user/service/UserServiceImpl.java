package ru.artemdikov.bellproject.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artemdikov.bellproject.model.mapper.MapperFacade;
import ru.artemdikov.bellproject.user.dao.UserDao;
import ru.artemdikov.bellproject.user.dto.UserDto;
import ru.artemdikov.bellproject.user.model.User;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;
    private final MapperFacade<User, UserDto> mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(UserDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        dao.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserDto> users() {
        List<User> all = dao.all();
        return mapperFacade.mapAsListToDto(all);
    }
}
