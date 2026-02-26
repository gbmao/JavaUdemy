package com.appstestinglessons.estore.service;

import com.UserService;
import com.appstestinglessons.estore.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    UserService userService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl();
        firstName = "Sergey";
        lastName = "Kargolopov";
        email = "test@test.com";
        password = "123456789";
        repeatPassword = "123456789";
    }

    @DisplayName("User object created")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject() {
        //Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert

        assertNotNull(user, "the createUser() should not have returned null");
        assertEquals(firstName, user.getFirstName(), "User's firstName is incorrect");
        assertEquals(lastName, user.getLastName(), "User's lastname is incorrect");
        assertEquals(email, user.getEmail(), "User's email is incorrect");
        assertNotNull(user.getId(), "User is is missing");
    }

    @DisplayName("Empty first name causes correct exception")
    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        firstName = "";

        String expectedExceptionMessage = "User's first name is empty";


        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Empty first name should have caused an Illegal argument exception");

        assertEquals(expectedExceptionMessage, thrown.getMessage());
    }

    @DisplayName("Empty last name causes exception")
    @Test
    void testCreateUser_whenLastNameIsEmpty_throwsIllegalArgumentException() {

        // Arrange
        lastName = "";
        String expectedThrowMessage = "User's last name is empty";

        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Empty last name should have returned Illegal Argument Exception");

        // Assert
        assertEquals(expectedThrowMessage, thrown.getMessage());
    }

    @DisplayName("Empty email return exception")
    @Test
    void testCreateUser_whenEmailIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        email = "";
        String expectedThrownMessage = "User's email is empty";

        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Empty email should have thrown Illegal Argument Exception");

        // Assert
        assertEquals(expectedThrownMessage, thrown.getMessage());
    }

    @DisplayName("Password not equals return exception with message")
    @Test
    void testCreateUser_whenPasswordIsNotEqual_throwsIllegalArgumentException() {
        // Arrange
        repeatPassword = "1234";
        String expectedMessage = "Password does not match";

        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Not matching password should be thrown Illegal Argument Exception");

        // Assert
        assertEquals(expectedMessage, thrown.getMessage());

    }

    @DisplayName("Password empty return Illegal Argument")
    @Test
    void testCreateUser_whenPasswordIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        password = "";
        repeatPassword = "";
        String expectedMessage = "Invalid password";

        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Empty password should thrown Illegal Argument Exception");

        // Assert
        assertEquals(expectedMessage, thrown.getMessage());
    }


}
