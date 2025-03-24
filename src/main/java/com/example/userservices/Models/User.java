package com.example.userservices.Models;

import jakarta.persistence.ManyToMany;

import java.util.List;

public class User extends BaseModel{
    private String name;
    private String email;
    private String HashPassword;
    private boolean isEmailVerified;
    @ManyToMany
    private List<Roles> rolesList;
}
