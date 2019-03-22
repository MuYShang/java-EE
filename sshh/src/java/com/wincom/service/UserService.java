package com.wincom.service;


import com.wincom.domain.User;

public interface UserService {
    User getUser(int id);
    void saveUser(User user);

}
