package Asiel.dao;

import Asiel.Dier;
import Asiel.Verblijf;
import org.hibernate.Hibernate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class VerblijfDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Verblijf> getVerblijven() {
        Query query = entityManager.createNamedQuery("Verblijf.findAll");
        return query.getResultList();
    }

    public Verblijf getVerblijf(long verblijfId) {
        return entityManager.find(Verblijf.class, verblijfId);
    }

    public void createVerblijf(Verblijf verblijf) {
        entityManager.persist(verblijf);
    }

    public Verblijf updateVerblijf(Verblijf verblijf, long verblijfId) {
        verblijf.setId(verblijfId);
        verblijf.setVerblijfNaam(verblijf.getVerblijfNaam());
        return entityManager.merge(verblijf);
    }

    public void deleteVerblijf(long verblijfId) {
        entityManager.remove(getVerblijf(verblijfId));
    }

    public List<Dier> getDierenInVerblijf(long verblijfId) {
        Verblijf verblijf = getVerblijf(verblijfId);
        List<Dier> dieren = verblijf.getDieren();
        Hibernate.initialize(dieren);
        return dieren;
    }

}
