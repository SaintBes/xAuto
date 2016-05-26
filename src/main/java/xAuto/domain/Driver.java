package xAuto.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by admssa on 16.05.2016.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="driverId")
public class Driver {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;

    private String driverName;
    private String driverPhone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Car car;

    public Driver() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }
}
