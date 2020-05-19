//package AsielPoging1;
//
//import javax.persistence.Id;
//import javax.validation.constraints.Size;
//import java.io.Serializable;
//import java.time.LocalDate;
//
//public class Dier implements Serializable {
//
//    @Id
//    private int dierId;
//
//    @Size(max=40)
//    private String dierNaam;
//
//    private String dierSoort;
//
//    private String geslacht;
//
//    private LocalDate datumBinnenkomst;
//
//    private LocalDate datumOpgehaald;
//
//
//    public Dier() {
//        // needed for EJB?
//    }
//
//    public Dier(int dierId, String dierNaam) {
//        this.dierId = dierId;
//        this.dierNaam = dierNaam;
//    }
//
//    public int getDierId() {
//        return dierId;
//    }
//
//    public void setDierId(int id) {
//        this.dierId = dierId;
//    }
//
//    public String getDierNaam() {
//        return dierNaam;
//    }
//
//    public void setDierNaam(String naam) {
//        this.dierNaam = dierNaam;
//    }
//
//    public String getDierSoort() {
//        return dierSoort;
//    }
//
//    public void setDierSoort(String soort) {
//        this.dierSoort = dierSoort;
//    }
//
//    public String getDierGeslacht() {
//        return geslacht;
//    }
//
//    public void setDierGeslacht(String geslacht) {
//        this.geslacht = geslacht;
//    }
//
//    public LocalDate datumBinnenkomst() {
//        return datumBinnenkomst;
//    }
//
//    public void setDatumBinnenkomst(LocalDate datumBinnenkomst) {
//        this.datumBinnenkomst = datumBinnenkomst;
//    }
//
//    public LocalDate datumOpgehaald() {
//        return datumOpgehaald;
//    }
//
//    public void setDatumOpgehaald(LocalDate datumOpgehaald) {
//        this.datumOpgehaald = datumOpgehaald;
//    }
//
//    @Override
//    public String toString() {
//        return "Dier{" +
//                "id is " + dierId +
//                "naam is " + dierNaam + "}";
//    }
//
//}
