package Asiel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Verblijven")
@NamedQuery(name = "Verblijf.findAll", query = "SELECT v FROM Verblijf v")
public class Verblijf implements Serializable {

    @Id
    private long verblijfId;

    @Column
    @Size(max=40)
    private String verblijfNaam;

    public long getVerblijfId() {
        return verblijfId;
    }

    public void setVerblijfId() {
        this.verblijfId = verblijfId;
    }

    public String getVerblijfNaam() {
        return verblijfNaam;
    }

    public void setVerblijfNaam() {
        this.verblijfNaam = verblijfNaam;
    }
}
