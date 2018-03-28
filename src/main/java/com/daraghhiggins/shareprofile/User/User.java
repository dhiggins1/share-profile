package com.daraghhiggins.shareprofile.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User{
    @Id
    @Column(name = "userId")
    private int userId;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "surnName")
    private String surnName;
    @Column(name = "password")
    private String password;
    @Column(name = "access_code")
    private int access_code;
    @Column(name = "email")
    private String email;
//    private Map<String, List<Double>> shares;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String username) {
        this.user_name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurnName() {
        return surnName;
    }

    public void setSurnName(String surnName) {
        this.surnName = surnName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccess_code() {
        return access_code;
    }

    public void setAccess_code(int access_code) {
        this.access_code = access_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
