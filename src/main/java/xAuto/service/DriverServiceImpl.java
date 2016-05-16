package xAuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xAuto.dao.DriverDAO;
import xAuto.domain.Driver;

import java.util.List;

/**
 * Created by admssa on 16.05.2016.
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverDAO driverDAO;

    @Override
    public Driver addDriver(Driver driver) {
        return driverDAO.createDriver(driver);
    }

    @Override
    @Transactional(readOnly = true)
    public Driver getDriver(int driverId) {
        return driverDAO.readDriver(driverId);
    }

    @Override
    public void updateDriver(Driver driver) {
        driverDAO.updateDriver(driver);

    }

    @Override
    public void deleteDriver(Driver driver) {
        driverDAO.deleteDriver(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }
}
