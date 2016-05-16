package xAuto.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xAuto.domain.Driver;

import java.util.List;

/**
 * Created by admssa on 16.05.2016.
 */
@Repository
public class DriverDAOImpl implements DriverDAO {

    @Autowired
    SessionFactory sessionFactory;

    public DriverDAOImpl() {
    }

    @Override
    public Driver createDriver(Driver driver) {
        sessionFactory.getCurrentSession().save(driver);
        return driver;

    }

    @Override
    public Driver readDriver(int driverId) {
        return (Driver) sessionFactory.getCurrentSession().get(Driver.class, driverId);

    }

    @Override
    public void updateDriver(Driver driver) {
        sessionFactory.getCurrentSession().update(driver);
    }

    @Override
    public void deleteDriver(Driver driver) {
        sessionFactory.getCurrentSession().delete(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return sessionFactory.getCurrentSession().createCriteria(Driver.class).list();
    }
}
