package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;
import pojo.User;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class my1Test {
    @Test
    public void findUserByIdTest() throws Exception{
        //读取配置文件
        //全局配置文件的路径
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用sqlSession的增删改查方法
        //第一个参数表示statement的唯一标示
        User user = sqlSession.selectOne("test.findUserById",1);
        System.out.println(user);

        //关闭资源
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() throws Exception{
        //读取配置文件
        //全局配置文件的路径
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用sqlSession的增删改查方法
        //第一个参数表示statement的唯一标示
        List<User> list = sqlSession.selectList("test.findUserByName","小明");
            System.out.println(list);
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void insertUserTest() throws Exception{
        //读取配置文件
        //全局配置文件的路径
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("控控");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("好几款海底隧道");

        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
}
