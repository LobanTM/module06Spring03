package com.loban.spring.service;

import com.loban.spring.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
