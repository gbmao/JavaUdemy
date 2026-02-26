package com.appstestinglessons.estore.service;

import com.UserService;
import com.appstestinglessons.estore.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject() {
        // Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "Sergey";
        String lastName = "Kargolopov";
        String email = "test@test.com";
        String password = "123456789";
        String repeatPassword = "123456789";

        //Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert

        assertNotNull(user, "the createUser() should not have returned null");
    }

    @Test
    void testCreateUser_whenUserIsCreated_returnedUserObjectContainsSameFirstName() {
        // Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "Sergey";
        String lastName = "Kargolopov";
        String email = "test@test.com";
        String password = "123456789";
        String repeatPassword = "123456789";

        // Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert
        assertEquals(firstName, user.getFirstName());
    }
}
