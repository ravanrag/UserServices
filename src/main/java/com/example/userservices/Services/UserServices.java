package com.example.userservices.Services;

import com.example.userservices.Models.Token;
import com.example.userservices.Models.User;
import com.example.userservices.Repos.TokenRepo;
import com.example.userservices.Repos.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServices {

    private final TokenRepo tokenRepo;
    private UserRepo userRepo;
    private BCryptPasswordEncoder passwordEncoder;
    UserServices(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder, TokenRepo tokenRepo){
        this.userRepo=userRepo;
        this.passwordEncoder =  passwordEncoder;
        this.tokenRepo = tokenRepo;
    }

    public User signUp(String userName, String email, String password) {
        User user = new User();
        user.setName(userName);
        user.setEmail(email);
        user.setHashPassword(passwordEncoder.encode(password));
        return userRepo.save(user);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Token login(String email, String password) {
        Optional<User> optionalUser = userRepo.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new UsernameNotFoundException("User with Email ID "+ email + " not found");
        }
        User user =optionalUser.get();
        if(!passwordEncoder.matches(password,user.getHashPassword()))
            throw new UsernameNotFoundException("UserName and password not Matching");

        Token token = generateToken(user);
        return tokenRepo.save(token);
    }

    private Token generateToken(User user) {
        Token token = new Token();
        token.setValue(RandomStringUtils.randomAlphanumeric(10));
        token.setExpiryAT(System.currentTimeMillis()+3600000);
        token.setUser(user);

        return token;
    }

    public User validateToken(String token) {
        Optional<Token> optionalToken = tokenRepo.findTokenByValueAndDeletedAndExpiryATGreaterThan(token,false,System.currentTimeMillis());
        if(optionalToken.isEmpty()){
            return null;
        }
        return optionalToken.get().getUser();
    }
}
