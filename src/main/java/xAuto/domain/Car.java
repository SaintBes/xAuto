package xAuto.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="carId")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carId;

    private String carNumber;

    private String carName;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car")
     private Driver carDriver;

    private boolean carActive;

    private long busyTimeStart;
    private long busyTimeOver;

    @OneToMany
    private List<Order> orders;




    public Car() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Driver getCarDriver() {
        return carDriver;
    }

    public void setCarDriver(Driver carDriver) {
        this.carDriver = carDriver;
    }

    public boolean isCarActive() { return carActive;
    }

    public void setCarActive(boolean carActive) { this.carActive = carActive;
    }

    public long getBusyTimeStart() {
        return busyTimeStart;
    }

    public void setBusyTimeStart(long busyTimeStart) {
        this.busyTimeStart = busyTimeStart;
    }

    public long getBusyTimeOver() {
        return busyTimeOver;
    }

    public void setBusyTimeOver(long busyTimeOver) {
        this.busyTimeOver = busyTimeOver;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
