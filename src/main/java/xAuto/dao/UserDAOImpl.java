package xAuto.dao;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import xAuto.domain.User;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

   // @Qualifier("sessionFactory")
    @Autowired
    SessionFactory sessionFactory;

    public UserDAOImpl() {

    }


    @Override
    public User addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
         return (User) sessionFactory.getCurrentSession().get(User.class, user.getId());
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User findUser(int userId) {
      return (User)  sessionFactory.getCurrentSession().get(User.class, userId);

    }

    @Override
    public User findUserByName(String username) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
}
