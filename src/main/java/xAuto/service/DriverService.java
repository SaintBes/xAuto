package xAuto.service;

import xAuto.domain.Driver;

import java.util.List;

/**
 * Created by admssa on 16.05.2016.
 */
public interface DriverService {

    Driver addDriver(Driver driver);
    Driver getDriver(int driverId);
    void updateDriver(Driver driver);
    void deleteDriver(Driver driver);
    List<Driver> getAllDrivers();

}
