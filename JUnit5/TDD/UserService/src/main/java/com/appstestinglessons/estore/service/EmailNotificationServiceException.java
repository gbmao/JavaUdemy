package com.appstestinglessons.estore.service;

public class EmailNotificationServiceException extends RuntimeException{
    private EmailNotificationServiceException(String message) {
        super(message);
    }
}
