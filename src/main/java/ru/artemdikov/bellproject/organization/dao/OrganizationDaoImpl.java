package ru.artemdikov.bellproject.organization.dao;

import org.springframework.stereotype.Repository;
import ru.artemdikov.bellproject.organization.model.Organization;
import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.user.model.User;

import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public Organization loadById(Long id) {
        return null;
    }

    @Override
    public List<User> loadByFilter(UserFilter userFilter) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }
}
