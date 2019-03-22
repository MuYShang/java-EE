package Dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    //1.根据用户id查询用户
    public User findUserById(int id);

    //2.根据用户名模糊查询用户
    public List<User> findUserByName(String name);

    //3.添加用户
    public void insertUser(User user);
}
