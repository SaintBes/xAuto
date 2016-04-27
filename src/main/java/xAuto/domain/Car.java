package xAuto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    private String carDriverName;

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

    public String getCarDriverName() {
        return carDriverName;
    }

    public void setCarDriverName(String carDriverName) {
        this.carDriverName = carDriverName;
    }

    public boolean isCarActive() {
        return carActive;
    }

    public void setCarActive(boolean carActive) {
        this.carActive = carActive;
    }
}
