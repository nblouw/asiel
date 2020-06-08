package Asiel.service;

import Asiel.DierMapper;
import Asiel.Verblijf;
import Asiel.dto.DierDto;
import Asiel.dto.VerblijfDto;
import Asiel.dto.VerblijvenDto;
import Asiel.exceptions.MyNotFoundException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VerblijfService {

    private DierMapper dierMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public VerblijfService() {

    }

    @Inject
    public VerblijfService(DierMapper dierMapper) {
        this.dierMapper = dierMapper;
    }

    public VerblijvenDto getVerblijven() {
        List<Verblijf> verblijfList = entityManager.createNamedQuery("Verblijf.findAll")
                .getResultList();

        List<VerblijfDto> verblijfDtoList = new ArrayList<>();
        verblijfList.forEach(verblijf -> {
            VerblijfDto verblijfDto = new VerblijfDto();
            verblijfDto.setId(verblijf.getId());
            verblijfDto.setVerblijfNaam(verblijf.getVerblijfNaam());

            List<DierDto> dierDtoList = new ArrayList<>();
            verblijf.getDieren().forEach(dier -> {
                dierDtoList.add(dierMapper.dierDto(dier));
            });

            verblijfDto.setDieren(dierDtoList);
            verblijfDtoList.add(verblijfDto);
        });

        VerblijvenDto verblijvenDto = new VerblijvenDto();
        verblijvenDto.setContent(verblijfDtoList);
        return verblijvenDto;
    }

    public VerblijfDto getVerblijf(long verblijfId) {
        Verblijf verblijf = (Verblijf) entityManager.createQuery("SELECT v FROM Verblijf v WHERE v.verblijfId = :verblijfId")
                .setParameter("verblijfId", verblijfId)
                .getSingleResult();

        if (verblijf == null) {
            throw new MyNotFoundException("verblijf met id " + verblijfId + " niet gevonden");
        }

        VerblijfDto verblijfDto = new VerblijfDto();
        verblijfDto.setId(verblijf.getId());
        verblijfDto.setVerblijfNaam(verblijf.getVerblijfNaam());

        return verblijfDto;
    }

    public void createVerblijf(VerblijfDto verblijfDto) {
        Verblijf verblijf = new Verblijf();
        verblijf.setVerblijfNaam(verblijfDto.getVerblijfNaam());
        entityManager.persist(verblijf);
    }

    public void updateVerblijf(long verblijfId, VerblijfDto verblijfDto) {
        Verblijf verblijf = (Verblijf) entityManager.createQuery("SELECT v FROM Verblijf v WHERE v.verblijfId = :verblijfId")
                .setParameter("verblijfId", verblijfId)
                .getSingleResult();

        verblijf.setVerblijfNaam(verblijfDto.getVerblijfNaam());

        entityManager.merge(verblijf);
    }

    public void deleteVerblijf(long verblijfId) {
        Verblijf verblijf = (Verblijf) entityManager.createQuery("SELECT v FROM Verblijf v WHERE v.verblijfId = :verblijfId")
                .setParameter("verblijfId", verblijfId)
                .getSingleResult();

        entityManager.remove(verblijf);
    }

}
