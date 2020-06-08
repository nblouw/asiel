package Asiel;

import Asiel.dao.VerblijfDao;
import Asiel.dto.VerblijfDto;
import Asiel.service.VerblijfService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/verblijven")
public class VerblijvenEndpoint {

    private VerblijfService verblijfService;

    @Inject
    public VerblijvenEndpoint(VerblijfService verblijfService) {
        this.verblijfService = verblijfService;
    }

    public VerblijvenEndpoint() {
        // needed for EJB
    }

    @GET
    public Response getVerblijven() {
        return Response.ok(verblijfService.getVerblijven()).build();
    }

    @GET
    @Path("/{id}")
    public Response getVerblijf(@PathParam("id") long verblijfId) {
        return Response.ok(verblijfService.getVerblijf(verblijfId)).build();
    }

    @POST
    public Response createVerblijf(VerblijfDto verblijfDto) {
        verblijfService.createVerblijf(verblijfDto);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateVerblijf(@PathParam("id") long verblijfId, VerblijfDto verblijfDto) {
        verblijfService.updateVerblijf(verblijfId, verblijfDto);
        return Response.ok(verblijfService.getVerblijf(verblijfId)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVerblijf(@PathParam("id") Long verblijfId) {
        verblijfService.deleteVerblijf(verblijfId);
        return Response.noContent().build();
    }
//
//    @GET
//    @Path("/{id}")
//    public Response getDierenInVerblijf(@PathParam("id") long verblijfId) {
//        return Response.ok(verblijfService.getDierenInVerblijf(verblijfId)).build();
//    }
}
