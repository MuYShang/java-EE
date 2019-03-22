package com.wincom.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wincom.domain.User;
import com.wincom.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user;
    @Override
    public User getModel() {
        return user;
    }
    private UserService userService;

    public String getUserName(){
        user=userService.getUser(1);
        System.out.println(user.getUsername());
        return SUCCESS;
    }
    public String saveUser(){
        User user=new User();
        user.setUsername("事务已提交");
        userService.saveUser(user);
        return SUCCESS;
    }

}
