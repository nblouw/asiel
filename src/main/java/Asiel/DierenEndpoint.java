package Asiel;

import Asiel.dao.DierDao;
import Asiel.dto.DierDto;
import Asiel.service.DierService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/dieren")
public class DierenEndpoint {

    private DierService dierService;

    @Inject
    public DierenEndpoint(DierService dierService) {
        this.dierService = dierService;
    }

    public DierenEndpoint() {
        // needed for EJB
    }

    @GET
    public Response getDieren() {
        return Response.ok(dierService.getDieren()).build();
    }

    @GET
    @Path("/{id}")
    public Response getDier(@PathParam("id") Long dierId) {
        return Response.ok(dierService.getAnimalById(dierId)).build();
    }

    @POST
    public Response createDier(DierDto dier) {
        dierService.createDier(dier);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDier(@PathParam("id") long dierId, DierDto dier) {
        dierService.updateDier(dierId, dier);
        return Response.ok(dierService.getAnimalById(dierId)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDier(@PathParam("id") Long dierId) {
        dierService.deleteDier(dierId);
        return Response.noContent().build();
    }
}
