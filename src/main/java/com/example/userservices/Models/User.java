package com.example.userservices.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String email;
    private String HashedPassword;
    private boolean isEmailVerified;
    @ManyToMany
    private List<Role> roles;


}
