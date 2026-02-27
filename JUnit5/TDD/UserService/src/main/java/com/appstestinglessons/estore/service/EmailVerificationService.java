package com.appstestinglessons.estore.service;

import com.appstestinglessons.estore.model.User;

public interface EmailVerificationService {
    void scheduleEmailConfirmation(User user);
}
