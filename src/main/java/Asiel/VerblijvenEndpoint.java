package Asiel;

import Asiel.dao.VerblijfDao;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/verblijven")
public class VerblijvenEndpoint {

    private VerblijfDao verblijfDao;

    @Inject
    public VerblijvenEndpoint(VerblijfDao verblijfDao) {
        this.verblijfDao = verblijfDao;
    }

    public VerblijvenEndpoint() {
        // needed for EJB
    }

    @GET
    public Response getVerblijven() {
        return Response.ok(verblijfDao.getVerblijven()).build();
    }

    @GET
    @Path("/{id}")
    public Response getVerblijf(@PathParam("id") long verblijfId) {
        return Response.ok(verblijfDao.getVerblijf(verblijfId)).build();
    }
}
