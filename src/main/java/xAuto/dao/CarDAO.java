package xAuto.dao;

import xAuto.domain.Car;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
public interface CarDAO {

    Car createCar(Car car);
    Car readCar(int carId);
    void updateCar(Car car);
    void deleteCar(Car car);
    List<Car> getAllCars();
}

