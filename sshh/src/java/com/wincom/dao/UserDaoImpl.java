package com.wincom.dao;


import com.wincom.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

public class UserDaoImpl implements UserDao{
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    public User getUser(int uid) {
        Session session = sessionFactory.getCurrentSession();
        //当getCurrentSession所在的方法，或者调用该方法的方法绑定了事务之后，session就与当前线程绑定了，也就能通过currentSession来获取，否则就不能。
        User user = session.get(User.class, uid);
        return user;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        System.out.println("=======" + user.getUsername());
        //使用getCurrentSession后，hibernate 自己维护session的关闭，写了反而会报错
    }
}
