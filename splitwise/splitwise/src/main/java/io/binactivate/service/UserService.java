package io.binactivate.service;

import io.binactivate.model.User;
import io.binactivate.repository.UserRepository;

public class UserService {
    

    public User createUser(String name, String email)
    {
        if(UserRepository.userHashMap.containsKey(email))
        {
            return UserRepository.userHashMap.get(email);
        }

        User newUser = new User(name, email);
        UserRepository.userHashMap.put(email, newUser);

        return newUser;
    }

}
