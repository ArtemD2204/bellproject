package ru.artemdikov.bellproject.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.artemdikov.bellproject.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> all() {
//        TypedQuery<Office> query = em.createQuery("SELECT u FROM Office u", Office.class);
//        return query.getResultList();

        Map<String, String> map = new HashMap<>();
//        map.put("officeId", "1");
//        map.put("citizenshipCode", "643");
//        map.put("firstName", "John");

        return loadByFilter(map);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadById(Long id) {
        return em.find(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadProxyById(Long id) {
        return em.getReference(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> loadByFilter(Map<String, String> filters) {
        CriteriaQuery<Office> criteriaQuery = buildCriteria(filters);
        TypedQuery<Office> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private CriteriaQuery<Office> buildCriteria(Map<String, String> filters) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);
        Root<Office> office = criteria.from(Office.class);
        Predicate[] predicates = new Predicate[filters.size()];
        int index = 0;
        for(Map.Entry<String, String> entry : filters.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            if (value != null) {
                if ("officeId".equals(key)) {
                    predicates[index++] = builder.equal(office.get("office").get("id"), value);
                } else if ("docCode".equals(key)) {
                    predicates[index++] = builder.equal(office.get("document").get("documentType").get("code"), value);
                } else if ("citizenshipCode".equals(key)) {
                    predicates[index++] = builder.equal(office.get("country").get("code"), value);
                } else {
                    predicates[index++] = builder.equal(office.get(key), value);
                }
            }
        }
        criteria = criteria.where(predicates);
        return criteria;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }
}
