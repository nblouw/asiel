package Asiel.dto;

import Asiel.Dier;

import java.util.List;

public class VerblijfDto {

    private long verblijfId;
    private String verblijfNaam;
    private List<DierDto> dieren;

    public long getId() {
        return verblijfId;
    }

    public void setId(long verblijfId) {
        this.verblijfId = verblijfId;
    }

    public String getVerblijfNaam() {
        return verblijfNaam;
    }

    public void setVerblijfNaam(String verblijfNaam) {
        this.verblijfNaam = verblijfNaam;
    }

    public List<DierDto> getDieren() {
        return dieren;
    }

    public void setDieren(List<DierDto> dieren) {
        this.dieren = dieren;
    }
}
