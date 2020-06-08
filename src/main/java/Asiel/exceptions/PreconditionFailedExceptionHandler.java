package Asiel.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PreconditionFailedExceptionHandler implements ExceptionMapper <PreconditionFailedException>{
    @Override
    public Response toResponse(PreconditionFailedException exception) {
        java.lang.Error error = new java.lang.Error(exception.getMessage());
        return Response.status(Response.Status.PRECONDITION_FAILED).entity(error).build();
    }
}
