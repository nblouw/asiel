package Asiel.dao;

import Asiel.Verblijf;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class VerblijfDao {

    @PersistenceContext(name = "Verblijf")
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
}
