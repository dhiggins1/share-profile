package com.daraghhiggins.shareprofile.Utils;

import com.daraghhiggins.shareprofile.User.User;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class UserUtility {
    public String hash(String raw) {
        return Hashing.sha256().hashString(raw, StandardCharsets.UTF_8).toString();
    }

    public static int createUserWithOrWithoutPrivilege() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want root access?");
        String ans = in.next();
        if(ans.toLowerCase().equals("yes")) {
            if (createUserWithRoot()) {
                return 1;
            }
            System.out.println("Incorrect password. User creation failed.");
            return -1;
        }
        return 0;
    }

    public static boolean createUserWithRoot() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter root password: One attempt...");
        String accessCheck = in.next();

        return accessCheck.equals("shroot");
    }

    public static boolean checkIfUserHasPermissionForRoot(Optional<User> user) {
        return user.get().getAccess_code() == 0;
    }

    public List<String> parseCredentials(String cred)  {
        String decodedCreds = decodeCredentials(cred);
        return Arrays.asList(decodedCreds.split(":"));
    }

    public String decodeCredentials(String cred) {
        byte[] decodedBytes = Base64.getDecoder().decode(cred);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        UserUtility userUtility = new UserUtility();
        List<String> testingCreds = userUtility.parseCredentials("aGlnejU1NTpwYXNzd29yZA==");
        System.out.println("User: "+ testingCreds.get(0));
        System.out.println("Password: "+ testingCreds.get(1));

    }
}
