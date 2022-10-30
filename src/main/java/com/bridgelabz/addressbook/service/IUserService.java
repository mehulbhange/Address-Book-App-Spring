package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.entity.User;

public interface IUserService {
    User createUser(User user);
    String userLogin(User user);

    User loadUserByUsername(String username);
}
