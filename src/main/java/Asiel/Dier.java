package Asiel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Dieren", uniqueConstraints = {@UniqueConstraint(columnNames = "dierId")})
@NamedQuery(name = "Dier.findAll", query = "SELECT d FROM Dier d")
public class Dier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dierId", unique = true)
    private long dierId;

    @Column
    @Size(max=40)
    private String dierNaam;

    @Column
    private LocalDate datumBinnenkomst;

    @Column
    private String dierSoort;

    @Column
    @Enumerated(EnumType.STRING)
    private DierGeslacht dierGeslacht;

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

    public DierGeslacht getDierGeslacht() {
        return dierGeslacht;
    }

    public void setDierGeslacht(DierGeslacht dierGeslacht) {
        this.dierGeslacht = dierGeslacht;
    }

}

