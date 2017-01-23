
package xyz.codingmentor.exeptions;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static final Logger LOGGER = Logger.getLogger(RestServiceExceptionMapper.class.getSimpleName());
    @Override
    public Response toResponse(Throwable exception) {
        LOGGER.log(Level.SEVERE, "Exception was thrown",exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorDTO(exception.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
