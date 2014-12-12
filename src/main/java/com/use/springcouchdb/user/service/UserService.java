package com.use.springcouchdb.user.service;

import com.use.springcouchdb.user.model.User;

/**
 * Created by usegutierrez on 12/10/14.
 */

public interface UserService {

    User findByUsername(String username);

    void insertUser(User user);
}
