package com.daraghhiggins.shareprofile.Utils;

import com.daraghhiggins.shareprofile.User.User;
import org.json.JSONObject;

import java.net.Authenticator;
import java.util.List;
import java.util.Optional;

public class BasicAuthenticator {
    public User authenticate(String userObject) {
        UserUtility userUtility = new UserUtility();
        List<String> userCreds = userUtility.parseCredentials(userObject);
        System.out.println("User: "+ userCreds.get(0));
        System.out.println("Password: "+ userCreds.get(1));
        User user = UserDAO.getInstance().getUserByUsername(userCreds.get(0));
        String passwordInput = userUtility.hash(userCreds.get(1));

        if(passwordInput.equals(user.getPassword())) {
            return user;
        } else {
            System.out.println("Could not find user");
        }
        return null;
    }

    public static void main(String[] args) {
//        BasicAuthenticator auth = new BasicAuthenticator();
//        JSONObject user = new JSONObject();
//        user.put("username", "liam");
//        user.put("password", "password");
//        auth.authenticate(user);
    }



}
