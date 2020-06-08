package Asiel.service;

import Asiel.Dier;
import Asiel.DierMapper;
import Asiel.Verblijf;
import Asiel.dao.DierDao;
import Asiel.dto.DierDto;
import Asiel.dto.DierenDto;
import Asiel.exceptions.MyNotFoundException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DierService {

    private DierDao dierDao;
    private DierMapper dierMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public DierService() {
    }

    @Inject
    public DierService(DierMapper dierMapper, DierDao dierDao) {
        this.dierDao = dierDao;
        this.dierMapper = dierMapper;
    }

    public DierenDto getDieren() {
        List<Dier> dierList = entityManager.createNamedQuery("Dier.findAll").getResultList();
        DierenDto dierenDto = new DierenDto();

        List<DierDto> dierDtoList = new ArrayList<>();
        dierList.forEach(dier -> {
            dierDtoList.add(dierMapper.dierDto(dier));
        });

        dierenDto.setContent(dierDtoList);
        return dierenDto;
    }

//    public DierDto getDier(long dierId) {
//        try {
//            Dier dier = (Dier) entityManager.createQuery("SELECT d FROM Dier d WHERE d.dierId = :dierId")
//                    .setParameter("dierId", dierId)
//                    .getSingleResult();
//
//            return dierMapper.dierDto(dier);
//        }
//        catch (Exception e) {
//            throw new MyNotFoundException("Dier met id " + dierId + " niet gevonden");
//        }
//
////
////        if (dier == null) {
////            throw new MyNotFoundException("Dier met id " + dierId + " niet gevonden");
////        }
//
//
//    }

    public DierDto getAnimalById(long id) {
        Dier animalById = dierDao.getDier(id);
        if(animalById == null) {
            throw new MyNotFoundException("Animal with ID " + id + " was not found on this server.");
        }
        return dierMapper.dierDto(animalById);
    }

    public void createDier(DierDto dierDto) {
        Dier dier = new Dier();
        dier.setDierNaam(dierDto.getDierNaam());

        Verblijf verblijf = (Verblijf) entityManager.createQuery("SELECT v FROM Verblijf v WHERE v.verblijfId = :verblijfId")
                .setParameter("verblijfId", dierDto.getVerblijf().getId())
                .getSingleResult();
        dier.setVerblijf(verblijf);

        entityManager.persist(dier);
    }

    public void updateDier(long dierId, DierDto dierDto) {
        Dier dier = (Dier) entityManager.createQuery("SELECT d FROM Dier d WHERE d.dierId = :dierId")
                .setParameter("dierId", dierId)
                .getSingleResult();
        dier.setDierNaam(dierDto.getDierNaam());

        Verblijf verblijf = (Verblijf) entityManager.createQuery("SELECT v FROM Verblijf v WHERE v.verblijfId = :verblijfId")
                .setParameter("verblijfId", dierDto.getVerblijf().getId())
                .getSingleResult();
        dier.setVerblijf(verblijf);

        entityManager.merge(dier);
    }

    public void deleteDier(long dierId) {
        Dier dier = (Dier) entityManager.createQuery("SELECT d FROM Dier d WHERE d.dierId = :dierId")
                .setParameter("dierId", dierId)
                .getSingleResult();
        entityManager.remove(dier);
    }

}
