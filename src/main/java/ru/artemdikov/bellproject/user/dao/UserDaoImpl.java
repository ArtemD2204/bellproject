package ru.artemdikov.bellproject.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
                "SELECT u FROM User u join fetch u.document d join fetch d.documentType",
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
    public List<User> loadByFilter(Map<String, Object> filters) {
        CriteriaQuery<User> criteriaQuery = buildCriteria(filters);
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

    private CriteriaQuery<User> buildCriteria(Map<String, Object> filters) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        List<Predicate> predicateList = new ArrayList<>();
        for(Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && (value.getClass() != String.class || !((String)value).isEmpty())) {
                if ("officeId".equals(key)) {
                    predicateList.add(builder.equal(user.get("office").get("id"), value));
                } else if ("docCode".equals(key)) {
                    predicateList.add(builder.equal(user.get("document").get("documentType").get("code"), value));
                } else if ("citizenshipCode".equals(key)) {
                    predicateList.add(builder.equal(user.get("country").get("code"), value));
                } else {
                    predicateList.add(builder.equal(user.get(key), value));
                }
            }
        }
        Predicate[] predicates = new Predicate[0];
        criteria = criteria.where(predicateList.toArray(predicates));
        return criteria;
    }
}
