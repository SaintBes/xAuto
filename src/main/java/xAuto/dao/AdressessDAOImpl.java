package xAuto.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xAuto.domain.Adressess;

import java.util.List;

/**
 * Created by admssa on 11.05.2016.
 */
@Repository
public class AdressessDAOImpl implements AdressessDAO {


    @Autowired
    SessionFactory sessionFactory;

    public AdressessDAOImpl() {
    }

    @Override
    public Adressess createAdressess(Adressess adressess) {
        sessionFactory.getCurrentSession().save(adressess);
        return adressess;

    }

    @Override
    public Adressess readAdressess(int adressessId) {
        return (Adressess) sessionFactory.getCurrentSession().get(Adressess.class, adressessId);

    }

    @Override
    public void updateAdressess(Adressess adressess) {
        sessionFactory.getCurrentSession().update(adressess);
    }

    @Override
    public void deleteAdressess(Adressess adressess) {
        sessionFactory.getCurrentSession().delete(adressess);
    }

    @Override
    public List<Adressess> getAllAdressesss() {
        return sessionFactory.getCurrentSession().createCriteria(Adressess.class).list();
    }
}
