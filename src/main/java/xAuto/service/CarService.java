package xAuto.service;

import xAuto.domain.Car;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
public interface CarService {

    Car addCar(Car car);
    Car getCar(int carId);
    void updateCar(Car car);
    void deleteCar(Car car);
    List<Car> getAllCars();
    void updateCarWDriver(Car car, int driverId);


}
