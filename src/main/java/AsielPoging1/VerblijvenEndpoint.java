//package AsielPoging1;
//
//import AsielPoging1.Dier;
//import AsielPoging1.DierVerblijf;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import java.util.ArrayList;
//import java.util.List;
//
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Path("/verblijven")
//public class VerblijvenEndpoint {
//
////    @GET
////    public List<DierVerblijf> getVerblijven() {
////        List<DierVerblijf> dierVerblijf = new ArrayList<>();
////        dierVerblijf.add(new DierVerblijf(1, "Tuin"));
////        dierVerblijf.add(new DierVerblijf(2, "Doos in de woonkamer"));
////        return dierVerblijf;
////    }
//
//    @GET
//    public List<DierVerblijf> getVerblijvenEnDieren() {
//        List<DierVerblijf> dierVerblijf = new ArrayList<>();
//        List<Dier> dieren = new ArrayList<>();
//
//        dieren.add(new Dier(1, "Streepje"));
//        dieren.add(new Dier(2, "Tommy"));
//
//        DierVerblijf dierVerblijfWelkDier = new DierVerblijf(1, "Tuin");
//        dierVerblijfWelkDier.setDierenInVerblijf(dieren);
//
//        dierVerblijf.add(dierVerblijfWelkDier);
//        dierVerblijf.add(new DierVerblijf(2, "Doos in de woonkamer"));
//        return dierVerblijf;
//    }
//
////    @GET
////    @Path("/{verblijfId}")
////    public DierVerblijf getVerblijf(@PathParam("verblijfId") int verblijfId) {
////        return new DierVerblijf(1, "Tuin");
////    }
//
//    @GET
//    @Path("/{dierId}")
//    public DierVerblijf getDierInWelkVerblijf(@PathParam("dierId") int dierId) {
//        List<Dier> dierInVerblijf = new ArrayList<>();
//        dierInVerblijf.add(new Dier(1, "Streepje"));
//        DierVerblijf verblijf = new DierVerblijf(1, "Tuin");
//        verblijf.setDierenInVerblijf(dierInVerblijf);
//        return verblijf;
//    }
//
//}
