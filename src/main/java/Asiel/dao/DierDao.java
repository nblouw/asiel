package Asiel.dao;

import Asiel.Dier;
import Asiel.exceptions.MyNotFoundException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DierDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Dier> getDieren() {
        Query query = entityManager.createNamedQuery("Dier.findAll");
        return query.getResultList();
    }

    public Dier getDier(long dierId) {
        try {
            return (Dier) entityManager.createQuery("SELECT d FROM Dier d WHERE d.dierId = :dierId")
                   .setParameter("dierId", dierId)
                   .getSingleResult();
    }
        catch (Exception e) {
            throw new MyNotFoundException("dlskjfsl;jf;les");
        }
}

    public void createDier(Dier dier) {
        entityManager.persist(dier);
    }

    public Dier updateDier(Dier dier, long dierId) {
        dier.setId(dierId);
        dier.setDierNaam(dier.getDierNaam());
        dier.setDatumBinnenkomst(dier.getDatumBinnenkomst());
        dier.setDierSoort(dier.getDierSoort());
        dier.setDierGeslacht(dier.getDierGeslacht());
        return entityManager.merge(dier);
    }

    public void deleteDier(long dierId) {
        Dier dier = getDier(dierId);
        entityManager.remove(dier);
    }

}
