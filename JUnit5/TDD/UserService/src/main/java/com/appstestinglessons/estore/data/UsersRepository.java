package com.appstestinglessons.estore.data;

import com.appstestinglessons.estore.model.User;

public interface UsersRepository {
    boolean save(User user);
}
