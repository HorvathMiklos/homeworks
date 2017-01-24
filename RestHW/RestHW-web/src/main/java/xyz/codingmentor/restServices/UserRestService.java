
package xyz.codingmentor.restservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.entities.UserEntity;
import xyz.codingmentor.exeptions.NotMatchingIdExeption;

/**
 *
 * @author mhorvath
 */
@Stateless
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService {
    private static final Map<String, UserEntity> USERS = new HashMap<>();
    /**
    *http://localhost:8080/RestHW-web/users
    */
    @GET
    public List<UserEntity> getAllUsers() {
        return new ArrayList(USERS.values());
    }
    /**
    *@param user is the userentity witch will be added to the map of users
    *http://localhost:8080/RestHW-web/users
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity addUser(UserEntity user) {
        user.setId(UUID.randomUUID().toString());
        USERS.put(user.getId(), user);
        return user;
    }
    /**
    *@param id is the id of user witch will be sent back to client
    *http://localhost:8080/RestHW-web/users/0958c494-2b6e-47df-b6fe-197b82ce87ba
    */
    @Path("/{id}")
    @GET
    public UserEntity getUser(@PathParam("id") String id){
        return USERS.get(id);
    }
    
    /**
     * @param id is the id of user witch will be modified
     * @param user is the user entity witch represents the new state of the user
     * http://localhost:8080/RestHW-web/users/0958c494-2b6e-47df-b6fe-197b82ce87ba
     */
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity modifyUser(@PathParam("id") String id,UserEntity user){
        if(id == null ? user.getId() == null : id.equals(user.getId())){
            USERS.put(user.getId(), user);
            return USERS.get(id);
        }
        throw new NotMatchingIdExeption(id);
    }
    
    /**
     * @param id is the id of user witch will be deleted
     * http://localhost:8080/RestHW-web/users/0958c494-2b6e-47df-b6fe-197b82ce87ba
     */
    @Path("/{id}")
    @DELETE
    public void deleteUser(@PathParam("id") String id){
        USERS.remove(id);
    }
}
