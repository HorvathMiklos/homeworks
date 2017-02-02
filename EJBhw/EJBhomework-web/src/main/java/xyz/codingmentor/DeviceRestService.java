/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.codingmentor;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.beans.Device;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("device")
@RequestScoped
public class DeviceRestService {
    @Context
    private UriInfo context;
    public DeviceRestService() {
    }
    @POST
    public void addDevice(){
    
    }
    @DELETE
    public void deleteDevice(){
    
    }
    @GET
    public void getDeviceById(){
    
    }
    /*
    @GET
    public List<Device> getAllDevices(){
    
    }
    */
}
