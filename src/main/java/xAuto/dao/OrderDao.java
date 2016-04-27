package xAuto.dao;

import xAuto.domain.Order;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
public interface OrderDAO {

    Order createOrder(Order order);
    Order readOrder(int orderId);
    void updateOrder(Order order);
    void deleteOrder(Order order);
    List<Order> getAllOrders();
}
