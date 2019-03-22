package test;

import Dao.DaoImpl.UserDaoImpl;
import Dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.User;

import java.io.InputStream;
import java.util.List;

public class DaoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception{
        //读取配置文件
        //全局配置文件路径
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserById() throws Exception{
        //创建userDao
        UserDao userDao =  new UserDaoImpl(sqlSessionFactory);

        User user = userDao.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void testFindUserByName() throws Exception{
        //创建userDao
        UserDao userDao =  new UserDaoImpl(sqlSessionFactory);

        List<User> list = userDao.findUserByName("小明");
        System.out.println(list);
    }
}
