package xAuto.domain;

import javax.persistence.*;

/**
 * Created by admssa on 27.04.2016.
 */
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carId;

    private String carNumber;

    private String carName;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car")
    private Driver carDriver;

    private boolean carActive;



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
}
