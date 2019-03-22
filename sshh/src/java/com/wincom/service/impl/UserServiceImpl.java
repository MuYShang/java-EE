package com.wincom.service.impl;


import com.wincom.dao.UserDao;
import com.wincom.domain.User;
import com.wincom.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(int id) {
        return userDao.getUser(id);
    }
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
