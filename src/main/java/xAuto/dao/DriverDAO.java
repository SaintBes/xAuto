package xAuto.dao;



import xAuto.domain.Driver;

import java.util.List;

/**
 * Created by admssa on 16.05.2016.
 */
public interface DriverDAO {
    Driver createDriver(Driver driver);
    Driver readDriver(int driverId);
    void updateDriver(Driver driver);
    void deleteDriver(Driver driver);
    List<Driver> getAllDrivers();
}
