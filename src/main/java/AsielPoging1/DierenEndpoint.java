//package AsielPoging1;
//
//import AsielPoging1.Dier;
//
//import javax.validation.Valid;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Path("/dieren")
//public class DierenEndpoint {
//
//    private Logger logger = Logger.getLogger("DierenEndpoint");
//
//    @GET
//    public List<Dier> getDieren() {
//        List<Dier> dieren = new ArrayList<>();
//        dieren.add(new Dier(1, "Streepje"));
//        dieren.add(new Dier(2, "Tommy"));
//        return dieren;
//    }
//
//    @GET
//    @Path("/{id}")
//    public Dier getDier(@PathParam("id") int dierId) {
//        return new Dier(1, "Streepje");
//    }
//
//    @PUT
//    @Path("/{id}")
//    public void updateDier(@PathParam("id") int dierId, Dier dier) {
//        dier.setDierId(dierId);
//        logger.info("updating id=" + dierId + " with dier=" + dier);
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public void deleteDier(@PathParam("id") int dierId) {
//
//    }
//
//    @POST
//    public Dier addContact(@Valid Dier dier) {
//        dier.setDierId(5);
//        return dier;
//    }
//}
