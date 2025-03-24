package com.example.userservices.DTOs;

import com.example.userservices.Models.Role;
import com.example.userservices.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    private String name;
    private String email;
    private List<Role>roleList;

    public static UserResponseDTO from (User user){
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setEmail(user.getEmail());
        responseDTO.setName(user.getName());
        responseDTO.setRoleList(user.getRoles());
        return responseDTO;
    }
}
