package com.example.userservices.Services;

import com.example.userservices.Models.User;
import com.example.userservices.Repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserRepo userRepo;
    private UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public User signUp(String name, String email, String password) {

        //Add email validation
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setHashedPassword(password);

        return userRepo.save(user);

    }

}
