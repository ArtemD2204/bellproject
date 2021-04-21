package ru.artemdikov.bellproject.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.office.model.Office;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    /**
     *
     * @param em
     */
    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> all() {
        Query query = em.createNativeQuery("SELECT o.* FROM Office o", Office.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadById(Long id) {
        TypedQuery<Office> query = em.createNamedQuery("Office.findById", Office.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadProxyById(Long id) {
        return em.getReference(Office.class, id);
    }

    @Override
    public List<Office> loadByFilter(OfficeFilter officeFilter) {
        CriteriaQuery<Office> criteriaQuery = buildCriteria(officeFilter);
        TypedQuery<Office> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Office office) {
        em.merge(office);
    }


    private CriteriaQuery<Office> buildCriteria(OfficeFilter officeFilter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);
        Root<Office> office = criteria.from(Office.class);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(builder.equal(office.get("organization").get("id"), officeFilter.getOrgId()));
        String name = officeFilter.getName();
        if (name != null && !name.isEmpty()) {
            predicateList.add(builder.equal(office.get("name"), name));
        }
        String phone = officeFilter.getPhone();
        if (phone != null && !phone.isEmpty()) {
            predicateList.add(builder.equal(office.get("phone"), phone));
        }
        Boolean isActive = officeFilter.getActive();
        if (isActive != null) {
            predicateList.add(builder.equal(office.get("isActive"), isActive));
        }
        Predicate[] predicates = new Predicate[0];
        criteria = criteria.where(predicateList.toArray(predicates));
        return criteria;
    }
}
