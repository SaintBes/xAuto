package xAuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xAuto.dao.CarDAO;
import xAuto.dao.DriverDAO;
import xAuto.domain.Car;
import xAuto.domain.Driver;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarDAO carDAO;

    @Autowired
    DriverDAO driverDAO;

    @Override
    public Car addCar(Car car) {
        return carDAO.createCar(car);
    }

    @Override
    @Transactional(readOnly = true)
    public Car getCar(int carId) {
        return carDAO.readCar(carId);
    }

    @Override
    public void updateCar(Car car) {
        carDAO.updateCar(car);

    }

    @Override
    public void deleteCar(Car car) {
        carDAO.deleteCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    public void updateCarWDriver(Car car, int driverId) {

    }


}
