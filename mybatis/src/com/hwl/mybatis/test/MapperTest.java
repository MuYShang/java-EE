package com.hwl.mybatis.test;

import com.hwl.mybatis.mapper.UserMapper;
import com.hwl.mybatis.pojo.User;
import com.hwl.mybatis.queryVo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {
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
    public void findUserById() throws Exception {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询方法
        User user = userMapper.findUserById(1);
        System.out.println(user);
        // 和spring整合后由spring管理
        sqlSession.close();

    }
    //按名字查找
    @Test
    public void findUserByName() throws Exception {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserByName("王五");
        for (User user :list) {
            System.out.println(user);
        }
        sqlSession.close();

    }
    //模糊查询
    @Test
    public void findUserByName2() throws  Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserByName2("王");
        for (User user: list) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void queryUser() throws  Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("张");
        queryVo.setUser(user);
        List<User> list = userMapper.queryUserName(queryVo);
        for (User u: list) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void queryUserCount() throws  Exception{
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.queryUserCount();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void queryUser1() throws  Exception {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setSex("1");
       /* user.setUsername("张");*/

        List<User> list = userMapper.queryUserWhere(user);
        for (User u: list) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void queryUser2() throws  Exception {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(24);

        queryVo.setIds(ids);
        List<User> list = userMapper.queryUserByIds(queryVo);
        for (User u: list) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void updateUser() throws  Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(28);
        user.setUsername("张飞");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("石器时代");

        userMapper.updateUser(user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws  Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(29);
        sqlSession.commit();
        sqlSession.close();
    }
}
