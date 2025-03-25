package com.example.userservices.Controllers;

import com.example.userservices.DTOs.SignUpRequestDTO;
import com.example.userservices.DTOs.UserResponseDTO;
import com.example.userservices.Models.User;
import com.example.userservices.Services.UserServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    UserServices userServices;

    public UserController(UserServices userServices){
        this.userServices = userServices;
    }
    @PostMapping("/signup")
    public UserResponseDTO signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){
        User user = userServices.signUp(signUpRequestDTO.getUserName(),signUpRequestDTO.getEmail(),signUpRequestDTO.getPassword());
        return UserResponseDTO.convertUserToUserResponseDTO(user);
    }
}
