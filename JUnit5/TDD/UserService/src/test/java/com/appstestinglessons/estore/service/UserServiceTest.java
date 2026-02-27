package com.appstestinglessons.estore.service;

import com.UserService;
import com.appstestinglessons.estore.data.UsersRepository;
import com.appstestinglessons.estore.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    EmailVerificationServiceImpl emailVerificationService;

    @Mock
    UsersRepository usersRepository;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init() {
        firstName = "Sergey";
        lastName = "Kargolopov";
        email = "test@test.com";
        password = "12345678";
        repeatPassword = "12345678";
    }

    @DisplayName("User object created")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject() {

        // Arrange
        Mockito.when(usersRepository.save(any(User.class))).thenReturn(true);

        //Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert

        assertNotNull(user, "the createUser() should not have returned null");
        assertEquals(firstName, user.getFirstName(), "User's firstName is incorrect");
        assertEquals(lastName, user.getLastName(), "User's lastname is incorrect");
        assertEquals(email, user.getEmail(), "User's email is incorrect");
        assertNotNull(user.getId(), "User is is missing");
        Mockito.verify(usersRepository, times(1))
                .save(any(User.class));

    }

    @DisplayName("If save() method causes RuntimeException, a UserServiceException is thrown")
    @Test
    void testCreateUser_whenSaveMethodThrowsException_thenThrowsUserServiceException() {
        // Arrange
        when(usersRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        // Act
        assertThrows(UserServiceException.class, () -> {
            User user = userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Should have thrown UserServiceException instead");

        // Assert
    }

    @DisplayName("EmailNotificationException is handled")
    @Test
    void testCreateUser_whenEmailVerificationExceptionThrown_throwsUserServiceException() {
        // Arrange
        when(usersRepository.save(any(User.class))).thenReturn(true);


        doThrow(EmailNotificationServiceException.class)
                .when(emailVerificationService)
                .scheduleEmailConfirmation(any(User.class));


        // Act
        assertThrows(UserServiceException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Should have thrown UserServiceException instead");

        // Assert
        verify(emailVerificationService, times(1)).
                scheduleEmailConfirmation(any(User.class));
    }

    @DisplayName("Schedule Email Confirmation is Executed")
    @Test
    void testCreateUser_whenUserCreated_schedulesEmailConfirmation(){
        // Arrange
        when(usersRepository.save(any(User.class))).thenReturn(true);

        doCallRealMethod().when(emailVerificationService)
                .scheduleEmailConfirmation(any(User.class));

        // Act

        userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert

        verify(emailVerificationService, times(1))
                .scheduleEmailConfirmation(any(User.class));
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

    @DisplayName("Password length below eight cause exception")
    @Test
    void testCreateUser_whenPasswordLengthIsAboveEight_shouldReturnIllegalArgumentException() {
        // Arrange
        password = "1234567";
        repeatPassword = "1234567";
        String expectedMessage = "Password length lower than 8";

        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Password with length below 8 should return Illegal Argument Exception");

        // Assert
        assertEquals(expectedMessage, thrown.getMessage());

    }


}
