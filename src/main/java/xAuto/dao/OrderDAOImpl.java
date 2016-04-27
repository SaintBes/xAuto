package xAuto.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xAuto.domain.Order;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    public OrderDAOImpl() {
    }

    @Override
    public Order createOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
        return order;

    }

    @Override
    public Order readOrder(int orderId) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, orderId);

    }

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }
}
