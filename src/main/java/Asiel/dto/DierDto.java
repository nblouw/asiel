package Asiel.dto;

import java.time.LocalDate;


public class DierDto {

    private Long dierId;
    private String dierNaam;
    private String dierSoort;
    private LocalDate datumBinnenkomst;
    private VerblijfDto verblijf;

    public long getId() {
        return dierId;
    }

    public void setId(long dierId) {
        this.dierId = dierId;
    }

    public String getDierNaam() {
        return dierNaam;
    }

    public void setDierNaam(String dierNaam) {
        this.dierNaam = dierNaam;
    }

    public LocalDate getDatumBinnenkomst() {
        return datumBinnenkomst;
    }

    public void setDatumBinnenkomst(LocalDate datumBinnenkomst) {
        this.datumBinnenkomst = datumBinnenkomst;
    }

    public String getDierSoort() {
        return dierSoort;
    }

    public void setDierSoort(String dierSoort) {
        this.dierSoort = dierSoort;
    }

    public VerblijfDto getVerblijf() {
        return verblijf;
    }

    public void setVerblijf(VerblijfDto verblijf) {
        this.verblijf = verblijf;
    }
}
