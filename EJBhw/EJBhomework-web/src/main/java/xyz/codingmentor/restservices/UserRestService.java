
package xyz.codingmentor.restservices;

import java.io.Serializable;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
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
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService implements Serializable {

    private static final String USER_KEY = "user";
    private static final String LOGIN_ERROR = "Log in first!";
    @Inject
    private UserDB userDB;

    @GET
    public List<UserEntity> getAllUsers() {
        return userDB.getAllUser();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO addUser(@Context HttpServletRequest request, UserEntity user) throws EntityException {

        HttpSession session = request.getSession(false);
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException(LOGIN_ERROR);
        }

        UserEntity currentUser = (UserEntity) session.getAttribute(USER_KEY);
        if (!currentUser.isAdmin()) {
            throw new IllegalStateException("You are not admin!");
        }

        return new ResultDTO(ResultType.SUCCESS, userDB.addUser(user));
    }

    @Path("/{userName}")
    @DELETE
    public UserEntity deleteUser(@Context HttpServletRequest request,@PathParam("userName") String userName) throws EntityException {
        HttpSession session = request.getSession(false);
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException(LOGIN_ERROR);
        }

        UserEntity currentUser = (UserEntity) session.getAttribute(USER_KEY);
        if (!currentUser.isAdmin()) {
            throw new IllegalStateException("You are not admin!");
        }        
        return userDB.deleteUser(userDB.getUser(userName));
    }

    @Path("/{userName}")
    @GET
    public UserEntity getUserByUserName(@PathParam("userName") String userName) throws EntityException {
        return userDB.getUser(userName);
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
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
    public ResultDTO logout(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException(LOGIN_ERROR);
        }
        request.getSession().invalidate();
        return new ResultDTO(ResultType.SUCCESS, "Logged out");
    }
}
