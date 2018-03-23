package com.daraghhiggins.shareprofile.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="users")
public class User {
    private int userId;
    private String username;
    private String firstName;
    private String surnName;
    private Map<String, List<Double>> shares;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
