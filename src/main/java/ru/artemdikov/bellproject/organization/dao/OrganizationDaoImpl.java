package ru.artemdikov.bellproject.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.artemdikov.bellproject.office.dto.OfficeFilter;
import ru.artemdikov.bellproject.office.model.Office;
import ru.artemdikov.bellproject.organization.dto.OrgFilter;
import ru.artemdikov.bellproject.organization.model.Organization;
import ru.artemdikov.bellproject.user.dto.UserFilter;
import ru.artemdikov.bellproject.user.model.User;

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
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    /**
     * Конструктор
     * @param em
     */
    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> loadByFilter(OrgFilter orgFilter) {
        CriteriaQuery<Organization> criteriaQuery = buildCriteria(orgFilter);
        TypedQuery<Organization> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

    private CriteriaQuery<Organization> buildCriteria(OrgFilter orgFilter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);
        Root<Organization> organization = criteria.from(Organization.class);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(builder.equal(organization.get("name"), orgFilter.getName()));
        String inn = orgFilter.getInn();
        if (inn != null && !inn.isEmpty()) {
            predicateList.add(builder.equal(organization.get("inn"), inn));
        }
        Boolean isActive = orgFilter.getActive();
        if (isActive != null) {
            predicateList.add(builder.equal(organization.get("isActive"), isActive));
        }
        Predicate[] predicates = new Predicate[0];
        criteria = criteria.where(predicateList.toArray(predicates));
        return criteria;
    }
}
