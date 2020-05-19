package Asiel;

import Asiel.dao.DierDao;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/dieren")
public class DierenEndpoint {
    private DierDao dierDAO;

    @Inject
    public DierenEndpoint(DierDao dierDAO) {
        this.dierDAO = dierDAO;
    }

    public DierenEndpoint() {
        // needed for EJB
    }

    @GET
    public Response getDieren() {
        return Response.ok(dierDAO.getDieren()).build();
    }

    @GET
    @Path("/{id}")
    public Response getDier(@PathParam("id") Long dierId) {
        return Response.ok(dierDAO.getDier(dierId)).build();
    }


    @POST
    public Response createDier(Dier dier) {
        dierDAO.createDier(dier);
        return Response.noContent().build();
    }

}
