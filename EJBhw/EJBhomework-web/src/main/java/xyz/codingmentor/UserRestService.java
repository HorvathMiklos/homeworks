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
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.db.UserDB;
import xyz.codingmentor.dto.ResultDTO;
import xyz.codingmentor.dto.ResultDTO.ResultType;
import xyz.codingmentor.exceptions.EntityException;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("users")
@SessionScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService implements Serializable {

    private static final String USER_KEY = "user";
    @Inject
    private UserDB userDB;

    @GET
    public List<UserEntity> getAllUsers() {
        return userDB.getAllUser();
    }

    @POST
    public ResultDTO addUser(@Context HttpServletRequest request, UserEntity user) throws EntityException {

        HttpSession session = request.getSession(false);
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException("Log in first!");
        }

        UserEntity currentUser = (UserEntity) session.getAttribute(USER_KEY);
        if (!currentUser.isAdmin()) {
            throw new IllegalStateException("You are not admin!");
        }

        return new ResultDTO(ResultType.SUCCESS, userDB.addUser(user));
    }

    @Path("/{userName}")
    @DELETE
    public UserEntity deleteUser() {
        return null;
    }

    @Path("/{userName}")
    @GET
    public UserEntity getUserByUserName() {
        return null;
    }

    @Path("/login")
    @POST
    public ResultDTO login(@Context HttpServletRequest request, UserEntity user) throws EntityException {
        if (!userDB.authenticate(user.getUsername(), user.getPassword())) {
            return new ResultDTO(ResultType.ERROR, "invalid username or password");
        }
        UserEntity userEntity = userDB.getUser(user.getUsername());
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(2000);
        session.setAttribute(USER_KEY, userEntity);
        return new ResultDTO(ResultType.SUCCESS, userEntity);
    }

    @POST
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO logout(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException("Log in first!");
        }
        request.getSession().invalidate();
        return new ResultDTO(ResultType.SUCCESS, "Logged out");
    }
}
