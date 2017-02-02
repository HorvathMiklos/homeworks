/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.codingmentor;

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
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.db.DeviceDB;
import xyz.codingmentor.dto.ResultDTO;
import xyz.codingmentor.exceptions.EntityException;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("device")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class DeviceRestService {

    @Inject
    private DeviceDB deviceDB;

    private static final String USER_KEY = "user";

    @GET
    public List<Device> getAllDevices() {
        return deviceDB.getAllDevices();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO addDevice(@Context HttpServletRequest request, Device device) throws EntityException {
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
        Device deviceToDelete = deviceDB.getDevice(deviceId);
        return new ResultDTO(ResultDTO.ResultType.SUCCESS, deviceDB.deleteDevice(deviceToDelete));
    }

    @Path("/{id}")
    @GET
    public Device getDeviceById(@PathParam("id") String id) throws EntityException {
        return deviceDB.getDevice(id);
    }
}
