package xAuto.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by admssa on 27.04.2016.
 */
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private String orderAddress;

    private long orderTimeStart;
    private long orderTimeOver;

    private boolean orderIsOpen;

    @ManyToOne
    private Car orderCar;

    @ManyToOne
    private Client orderClient;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public long getOrderTimeStart() {
        return orderTimeStart;
    }

    public void setOrderTimeStart(long orderTimeStart) {
        this.orderTimeStart = orderTimeStart;
    }

    public long getOrderTimeOver() {
        return orderTimeOver;
    }

    public void setOrderTimeOver(long orderTimeOver) {
        this.orderTimeOver = orderTimeOver;
    }

    public boolean isOrderIsOpen() {
        return orderIsOpen;
    }

    public void setOrderIsOpen(boolean orderIsOpen) {
        this.orderIsOpen = orderIsOpen;
    }

    public Car getOrderCar() {
        return orderCar;
    }

    public void setOrderCar(Car orderCar) {
        this.orderCar = orderCar;
    }

    public Client getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(Client orderClient) {
        this.orderClient = orderClient;
    }
}
