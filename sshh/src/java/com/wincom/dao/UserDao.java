package com.wincom.dao;

import com.wincom.domain.User;

public interface UserDao {
        User getUser(int  id);
        void saveUser(User user);

    }
