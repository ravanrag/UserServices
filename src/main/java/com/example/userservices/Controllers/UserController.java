package com.example.userservices.Controllers;

import com.example.userservices.DTOs.LoginRequestDTO;
import com.example.userservices.DTOs.SignUpRequestDTO;
import com.example.userservices.DTOs.UserResponseDTO;
import com.example.userservices.Models.Token;
import com.example.userservices.Models.User;
import com.example.userservices.Services.UserServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    UserServices userServices;

    public UserController(UserServices userServices){
        this.userServices = userServices;
    }
    @PostMapping("/signup")
    public UserResponseDTO signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){
        User user = userServices.signUp(signUpRequestDTO.getName(),signUpRequestDTO.getEmail(),signUpRequestDTO.getPassword());
        return UserResponseDTO.convertUserToUserResponseDTO(user);
    }

    @GetMapping("/login")
    public Token login(@RequestBody LoginRequestDTO loginRequestDTO){
        return userServices.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
    }

    @GetMapping("/validate/{token}")
    public UserResponseDTO validate(@PathVariable("token") String token){
        User user = userServices.validateToken(token);
        if(user == null)
            return null;
        return UserResponseDTO.convertUserToUserResponseDTO(user);
    }
}
