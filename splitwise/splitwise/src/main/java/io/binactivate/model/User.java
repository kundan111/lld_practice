package io.binactivate.model;

import java.util.HashMap;
import java.util.UUID;

public class User{
    
    private String userId;
    private String name;
    private String email;
    private HashMap<User,Double> balances;

    
    public HashMap<User, Double> getBalances() {
        return balances;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserId() {
        return userId;
    }


    public String getName() {
        return name;
    }


    public User(String name, String email) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.balances = new HashMap<>();
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    


    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User)
        {
            User givenUser = (User)obj;
            return userId.equals(givenUser.getUserId());
        }
        return false;
    }


}
