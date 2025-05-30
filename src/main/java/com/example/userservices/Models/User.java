package com.example.userservices.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String HashPassword;
    private boolean isEmailVerified;
    @ManyToMany
    private List<Role> roleList;
}
