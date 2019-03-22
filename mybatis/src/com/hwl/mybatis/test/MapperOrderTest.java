package com.hwl.mybatis.test;

import com.hwl.mybatis.mapper.OrderMapper;
import com.hwl.mybatis.mapper.UserMapper;
import com.hwl.mybatis.pojo.Order;
import com.hwl.mybatis.pojo.User;
import com.hwl.mybatis.queryVo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MapperOrderTest {
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
    public void queryAll() throws Exception {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.queryAll();
        for (Order order:list) {
            System.out.println(order);
        }
        sqlSession.close();

    }

    @Test
    public void queryAll2() throws Exception {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.queryAll1();
        for (Order order:list) {
            System.out.println(order);
        }
        sqlSession.close();

    }
}
