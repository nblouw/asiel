package Asiel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Verblijven", uniqueConstraints = {@UniqueConstraint(columnNames = "verblijfId")})
@NamedQuery(name = "Verblijf.findAll", query = "SELECT v FROM Verblijf v")
public class Verblijf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verblijfId", unique = true)
    private long verblijfId;

    @Column
    @Size(max=40)
    private String verblijfNaam;

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
}
