package com.daraghhiggins.shareprofile.Utils;

import com.daraghhiggins.shareprofile.User.User;
import org.json.JSONObject;

import java.net.Authenticator;
import java.util.Optional;

public class BasicAuthenticator {
    public Optional<User> authenticate(JSONObject userObject) {
        Optional<User> user = UserDAO.getInstance().getUserByUsername(userObject.getString("username"));
        UserUtility userUtility = new UserUtility();
        String passwordInput = userUtility.hash(userObject.getString("password"));

        if(passwordInput.equals(user.get().getPassword())) {
            return user;
        } else {
            System.out.println("Could not find user");
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        BasicAuthenticator auth = new BasicAuthenticator();
        JSONObject user = new JSONObject();
        user.put("username", "liam");
        user.put("password", "password");
        auth.authenticate(user);
    }



}
