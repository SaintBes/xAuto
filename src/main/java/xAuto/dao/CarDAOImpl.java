package xAuto.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xAuto.domain.Car;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
@Repository
public class CarDAOImpl implements CarDAO {

    @Autowired
    SessionFactory sessionFactory;

    public CarDAOImpl() {
    }

    @Override
    public Car createCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
        return car;

    }

    @Override
    public Car readCar(int carId) {
        return (Car) sessionFactory.getCurrentSession().get(Car.class, carId);

    }

    @Override
    public void updateCar(Car car) {
        sessionFactory.getCurrentSession().update(car);
    }

    @Override
    public void deleteCar(Car car) {
        sessionFactory.getCurrentSession().delete(car);
    }

    @Override
    public List<Car> getAllCars() {
        return sessionFactory.getCurrentSession().createCriteria(Car.class).list();
    }
}
