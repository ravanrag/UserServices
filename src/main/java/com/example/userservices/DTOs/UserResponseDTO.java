package com.example.userservices.DTOs;

import com.example.userservices.Models.Role;
import com.example.userservices.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    public String name;
    public String email;
    public List<Role> roles;

    public static UserResponseDTO convertUserToUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRoles(user.getRoleList());
        return userResponseDTO;
    }
}
