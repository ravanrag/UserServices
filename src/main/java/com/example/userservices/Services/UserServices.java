package com.example.userservices.Services;

import com.example.userservices.Models.User;
import com.example.userservices.Repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    private UserRepo userRepo;

    public User signUp(String userName, String email, String password) {
        User user = new User();
        user.setName(userName);
        user.setEmail(email);
        user.setHashPassword(password);

        return userRepo.save(user);

    }
}
