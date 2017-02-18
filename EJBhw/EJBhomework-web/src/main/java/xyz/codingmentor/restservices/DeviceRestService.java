
package xyz.codingmentor.restservices;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.beans.DeviceEntity;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.db.DeviceDB;
import xyz.codingmentor.dto.ResultDTO;
import xyz.codingmentor.exceptions.EntityException;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("devices")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class DeviceRestService {

    @Inject
    private DeviceDB deviceDB;

    private static final String USER_KEY = "user";

    @GET
    public List<DeviceEntity> getAllDevices() {
        return deviceDB.getAllDevices();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO addDevice(@Context HttpServletRequest request, DeviceEntity device) throws EntityException {
        HttpSession session = request.getSession(false);
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException("Log in first!");
        }

        UserEntity currentUser = (UserEntity) session.getAttribute(USER_KEY);
        if (!currentUser.isAdmin()) {
            throw new IllegalStateException("You are not admin!");
        }

        return new ResultDTO(ResultDTO.ResultType.SUCCESS, deviceDB.addDevice(device));
    }

    @Path("/{id}")
    @DELETE
    public ResultDTO deleteDevice(@Context HttpServletRequest request, @PathParam("id") String deviceId) throws EntityException {
        HttpSession session = request.getSession(false);
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException("Log in first!");
        }
        UserEntity currentUser = (UserEntity) session.getAttribute(USER_KEY);
        if (!currentUser.isAdmin()) {
            throw new IllegalStateException("You are not admin!");
        }
        DeviceEntity deviceToDelete = deviceDB.getDevice(deviceId);
        return new ResultDTO(ResultDTO.ResultType.SUCCESS, deviceDB.deleteDevice(deviceToDelete));
    }

    @Path("/{id}")
    @GET
    public DeviceEntity getDeviceById(@PathParam("id") String id) throws EntityException {
        return deviceDB.getDevice(id);
    }
}
