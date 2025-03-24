package com.example.userservices.DTOs;

import com.example.userservices.Models.Roles;
import com.example.userservices.Models.User;
import jakarta.servlet.http.PushBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    public String name;
    public String email;
    public List<Roles> rolesList;

    public static UserResponseDTO convertUserToUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setRolesList(user.getRolesList());
        return userResponseDTO;
    }
}
