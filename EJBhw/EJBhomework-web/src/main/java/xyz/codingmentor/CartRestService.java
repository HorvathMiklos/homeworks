/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.codingmentor;

import java.io.Serializable;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.cart.Cart;
import xyz.codingmentor.dto.ResultDTO;
import xyz.codingmentor.exceptions.EntityException;

/**
 * REST Web Service
 *
 * @author mhorvath
 */
@Path("cart")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
public class CartRestService implements Serializable {

    @Inject
    private Cart cart;
    
    private static final String USER_KEY = "user";

    @Path("/{id}/{count}")
    @POST
    public ResultDTO addDeviceToCart(@Context HttpServletRequest request, @PathParam("id") String deviceId, @PathParam("count") int count) throws EntityException {
        HttpSession session = request.getSession(false);
        if (null == session.getAttribute(USER_KEY)) {
            throw new IllegalStateException("Log in first!");
        }

        cart.addDevice(deviceId, count);
        return new ResultDTO(ResultDTO.ResultType.SUCCESS, cart.value().toString());
    }

    @DELETE
    public ResultDTO removeFromCart() {
        return null;
    }

    @POST
    public ResultDTO buyCart() {
        return null;
    }
}
