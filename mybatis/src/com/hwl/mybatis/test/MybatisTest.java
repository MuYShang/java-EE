package com.hwl.mybatis.test;

import com.hwl.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 3. 创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testQueryUserById() throws Exception {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
        User user = sqlSession.selectOne("test.findUserById", 1);
        // 6. 打印结果
        System.out.println(user);
        // 7. 释放资源
        sqlSession.close();
    }
    @Test
    public void testQueryUserByName() throws Exception {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
       List<User> list = sqlSession.selectList("test.findUserByName", "%王%");
        // 6. 打印结果
        for ( User user: list) {
            System.out.println(user);
        }
        // 7. 释放资源
        sqlSession.close();
    }

    @Test
    public void test() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("test.findUserByName2","王");
        for (User user: list) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void test1() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("张飞");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("的护国");
        sqlSession.insert("test.savaUser",user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(29);
        user.setUsername("吴志胜");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("的护国");
        sqlSession.insert("test.updateUser",user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void test3() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser",28);
        sqlSession.commit();
        sqlSession.close();
    }

}

