package io.binactivate.tic_tac_toe.service;

import java.util.HashMap;

import io.binactivate.tic_tac_toe.exceptions.SameSymbolforNewUserException;
import io.binactivate.tic_tac_toe.model.User;

public class UserService {
    
    private static HashMap<Character,User> allUsers = new HashMap<>();

    public static User creatUser(String name, char c){
        User user = null;

        if(allUsers.containsKey(c))
        {
            throw new SameSymbolforNewUserException(c + " is already taken up by " +  allUsers.get(c).getName());
        }

        user = new User(name, false, c);
        allUsers.put(c, user);

        return user;
    }

    public static HashMap<Character, User> getAllUsers() {
        return allUsers;
    }

    

    
}
