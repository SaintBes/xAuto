package xAuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xAuto.dao.AdressessDAO;
import xAuto.dao.OrderDAO;
import xAuto.domain.Adressess;
import xAuto.domain.Order;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    AdressessDAO adressessDAO;

    @Override
    public Order addOrder(Order order) {
        return orderDAO.createOrder(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrder(int orderId) {
        return orderDAO.readOrder(orderId);
    }

    @Override
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);

    }

    @Override
    public void deleteOrder(Order order) {
        orderDAO.deleteOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public void createNewOrder(Order order, List<Adressess> adressessList) {
        orderDAO.createOrder(order);
        for (Adressess adressess : adressessList) {
            adressess.setOrder(order);
            adressessDAO.createAdressess(adressess);
        }

    }



}
