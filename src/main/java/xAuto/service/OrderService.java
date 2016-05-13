package xAuto.service;

import xAuto.domain.Adressess;
import xAuto.domain.Order;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
public interface OrderService {

    Order addOrder(Order order);
    Order getOrder(int orderId);
    void updateOrder(Order order);
    void deleteOrder(Order order);
    List<Order> getAllOrders();
    void createNewOrder(Order order, List<Adressess> adressessList);
}
