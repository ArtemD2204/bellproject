package ru.artemdikov.bellproject.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.artemdikov.bellproject.exception.EntityNotFoundException;
import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadById(Long id) {
        Office office = em.find(Office.class, id);
        if (office == null) {
            throw new EntityNotFoundException("Office not found for id=" + id + ".");
        }
        return office;
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
        List<Office> offices = query.getResultList();
        if (offices.size() == 0) {
            throw new EntityNotFoundException("No offices were found. Please, change filters parameters.");
        }
        return offices;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
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
