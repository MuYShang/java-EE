package Dao.DaoImpl;

import Dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //依赖注入
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    @Override
    public User findUserById(int id) {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 调用SqlSession的增删改查方法
        // 第一个参数：表示statement的唯一标示
        User user = sqlSession.selectOne("test.findUserById", id);
        System.out.println(user);
        // 关闭资源
        sqlSession.close();
        return user;

    }

    @Override
    public List<User> findUserByName(String name) {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 调用SqlSession的增删改查方法
        // 第一个参数：表示statement的唯一标示
        List<User> list = sqlSession.selectList("test.findUserByName", name);
        System.out.println(list);
        // 关闭资源
        sqlSession.close();
        return list;

    }

    @Override
    public void insertUser(User user) {
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 调用SqlSession的增删改查方法
        // 第一个参数：表示statement的唯一标示
        sqlSession.insert("test.insertUser", user);

        System.out.println(user.getId());
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();

    }
}
