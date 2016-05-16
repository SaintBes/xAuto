package xAuto.domain;

import javax.persistence.*;

/**
 * Created by admssa on 16.05.2016.
 */
@Entity
public class Driver {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;

    private String driverName;
    private String driverPhone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carId")
    private Car car;

    public Driver() {
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
