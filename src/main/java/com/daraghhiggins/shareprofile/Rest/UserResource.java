package com.daraghhiggins.shareprofile.Rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.daraghhiggins.shareprofile.User.User;
import com.daraghhiggins.shareprofile.Utils.BasicAuthenticator;
import com.daraghhiggins.shareprofile.Utils.UserDAO;
import org.json.JSONObject;

import java.util.List;
import java.util.Optional;

@Path("/users")
public class UserResource {

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public User getUser(@FormParam("username") String userObject) {
        BasicAuthenticator basicAuthenticator = new BasicAuthenticator();
        return basicAuthenticator.authenticate(userObject);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    public String print() {
        return "hello";
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register(@FormParam("username") String username,
                         @FormParam("password") String password,
                         @FormParam("email") String email,
                         @FormParam("firstName") String firstName,
                         @FormParam("surnName") String surnName){
        UserDAO.getInstance().createUser(username, password,firstName, surnName);
        return "Creation finished..";
    }

}
