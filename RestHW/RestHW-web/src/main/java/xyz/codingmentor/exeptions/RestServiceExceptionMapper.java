
package xyz.codingmentor.exeptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.dto.ErrorDTO;

/**
 *
 * @author mhorvath
 */
@Provider
public class RestServiceExceptionMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorDTO(exception.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
