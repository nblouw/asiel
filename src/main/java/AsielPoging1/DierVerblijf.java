//package AsielPoging1;
//
//import javax.persistence.Id;
//import javax.validation.constraints.Size;
//import java.util.List;
//
//public class DierVerblijf {
//
//    @Id
//    private int verblijfId;
//
//    @Size(max=40)
//    private String verblijfNaam;
//
//    private List<Dier> dierenInVerblijf;
//
//
//    public DierVerblijf() {
//        // needed for EJB?
//    }
//
//    public DierVerblijf(int verblijfId, String verblijfNaam) {
//        this.verblijfId = verblijfId;
//        this.verblijfNaam = verblijfNaam;
//    }
//
//    public int getVerblijfId() {
//        return verblijfId;
//    }
//
//    public void setVerblijfId() {
//        this.verblijfId = verblijfId;
//    }
//
//    public String getVerblijfNaam() {
//        return verblijfNaam;
//    }
//
//    public void setVerblijfNaam() {
//        this.verblijfNaam = verblijfNaam;
//    }
//
//    public List<Dier> getDierenInVerblijf() {
//        return dierenInVerblijf;
//    }
//
//    public void setDierenInVerblijf(List<Dier> dierenInVerblijf) {
//        this.dierenInVerblijf = dierenInVerblijf;
//    }
//
//
//
//}
