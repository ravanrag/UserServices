package com.example.userservices.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class SignUpRequestDTO {
    private String name;
    private String email;
    private String password;


}
