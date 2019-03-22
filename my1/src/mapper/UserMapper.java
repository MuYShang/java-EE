package mapper;

import pojo.User;

public interface UserMapper {
    //1根据用户ID查询用户信息
    public User findUserById(int id) throws  Exception;

    //2添加用户
    public void insertUser(User user) throws Exception;
}
