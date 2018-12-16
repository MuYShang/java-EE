package com.hwl.mybatis.mapper;

import com.hwl.mybatis.pojo.User;
import com.hwl.mybatis.queryVo.QueryVo;

import java.util.List;

public interface UserMapper {
    //根据ID查询用户
    User findUserById(Integer id);

    //根据名字模糊查询
    List<User> findUserByName(String username);
    List<User> findUserByName2(String username);
    List<User> queryUserName(QueryVo queryVo);

    List<User> queryUserWhere(User user);

    List<User> queryUserByIds(QueryVo queryVo);
    int queryUserCount();
    //添加用户
    User savaUser(User user);

    //修改用户
    void updateUser(User user);
    //删除用户
    void deleteUser(Integer id);
}
