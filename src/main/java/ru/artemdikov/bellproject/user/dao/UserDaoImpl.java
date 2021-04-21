package ru.artemdikov.bellproject.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.*;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    /**
     * Конструктор
     * @param em
     */
    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> all() {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u join fetch u.document d join fetch d.documentType join fetch u.country",
                User.class
        );
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadById(Long id) {
        return em.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> loadByFilter(UserFilter userFilter) {
        CriteriaQuery<User> criteriaQuery = buildCriteria(userFilter);
        TypedQuery<User> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user) {
        em.persist(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user) {
        em.merge(user);
    }

    private CriteriaQuery<User> buildCriteria(UserFilter userFilter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(builder.equal(user.get("office").get("id"), userFilter.getOfficeId()));
        String firstName = userFilter.getFirstName();
        if (firstName != null && !firstName.isEmpty()) {
            predicateList.add(builder.equal(user.get("firstName"), firstName));
        }
        String secondName = userFilter.getSecondName();
        if (secondName != null && !secondName.isEmpty()) {
            predicateList.add(builder.equal(user.get("secondName"), secondName));
        }
        String middleName = userFilter.getMiddleName();
        if (middleName != null && !middleName.isEmpty()) {
            predicateList.add(builder.equal(user.get("middleName"), middleName));
        }
        String position = userFilter.getPosition();
        if (position != null && !position.isEmpty()) {
            predicateList.add(builder.equal(user.get("position"), position));
        }
        String docCode = userFilter.getDocCode();
        if (docCode != null && !docCode.isEmpty()) {
            predicateList.add(builder.equal(user.get("document").get("documentType").get("code"), docCode));
        }
        String citizenshipCode = userFilter.getCitizenshipCode();
        if (citizenshipCode != null && !citizenshipCode.isEmpty()) {
            predicateList.add(builder.equal(user.get("country").get("code"), citizenshipCode));
        }
        Predicate[] predicates = new Predicate[0];
        criteria = criteria.where(predicateList.toArray(predicates));
        return criteria;
    }
}
