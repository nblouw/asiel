package Asiel.dao;

import Asiel.Verblijf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        return (Verblijf) entityManager.createQuery("SELECT v FROM Verblijf v WHERE v.verblijfId = :verblijfId")
                .setParameter("verblijfId", verblijfId)
                .getSingleResult();
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

}
