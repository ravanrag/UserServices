package com.example.userservices.Controller;

import com.example.userservices.DTOs.SignUpRequestDTO;
import com.example.userservices.DTOs.UserResponseDTO;
import com.example.userservices.Models.User;
import com.example.userservices.Services.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    UserController(UserService userService){
        this.userService=userService;
    }

    public UserResponseDTO signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){
        User user = userService.signUp(signUpRequestDTO.getName(),signUpRequestDTO.getEmail(),signUpRequestDTO.getPassword());
        return UserResponseDTO.from(user);
    }
}
