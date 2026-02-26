package com.appstestinglessons.estore.service;

import com.UserService;
import com.appstestinglessons.estore.data.UsersRepository;
import com.appstestinglessons.estore.data.UsersRepositoryImpl;
import com.appstestinglessons.estore.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User createUser(String firstName,
                           String lastName,
                           String email,
                           String password,
                           String repeatPassword) {

        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("User's first name is empty");
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("User's last name is empty");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("User's email is empty");
        }

        if(!password.equals(repeatPassword)) {
            throw new IllegalArgumentException("Password does not match");
        }

        // I don't need to check repeatPassword since it will throw password does not match
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Invalid password");
        }

        if(password.length() < 8) {
            throw new IllegalArgumentException("Password length lower than 8");
        }

        User user = new User(firstName,lastName,email,UUID.randomUUID().toString());


        boolean isUserCreated = usersRepository.save(user);
        if(!isUserCreated) throw new UserServiceException("Could not create user");


        return new User(firstName, lastName, email, UUID.randomUUID().toString());
    }
}
