/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.codingmentor;

import java.io.Serializable;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.db.UserDB;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("users")
@SessionScoped
public class UserRestService implements Serializable{
    @Inject
    private UserDB userDB;
    
    @GET
    public List<UserEntity> getAllUsers(){
            return userDB.getAllUser();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(@Context HttpServletRequest request){
        
    }
    @Path("/{userName}")
    @DELETE
    public void deleteUser(){
    
    }
    
    @Path("/{userName}")
    @GET
    public UserEntity getUserByUserName(){
        return null;
    }
   
    
    @Path("/login")
    @PUT
    public void login(){
    
    }
}
