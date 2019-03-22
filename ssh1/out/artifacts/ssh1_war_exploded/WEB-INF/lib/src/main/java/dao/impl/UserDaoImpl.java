package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public List<User> findAllUser(){
        return this.getHibernateTemplate().find("from User");
    }
}
