package Asiel.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<MyNotFoundException> {
    @Override
    public Response toResponse(MyNotFoundException exception) {
        System.out.print("hoi");
        Error error = new Error(exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }

}
