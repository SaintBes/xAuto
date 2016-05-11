package xAuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xAuto.dao.AdressessDAO;
import xAuto.domain.Adressess;

import java.util.List;

/**
 * Created by admssa on 11.05.2016.
 */
@Service
@Transactional
public class AdressessServiceImpl implements AdressessService {

    @Autowired
    AdressessDAO adressessDAO;

    @Override
    public Adressess addAdressess(Adressess adressess) {
        return adressessDAO.createAdressess(adressess);
    }

    @Override
    @Transactional(readOnly = true)
    public Adressess getAdressess(int adressessId) {
        return adressessDAO.readAdressess(adressessId);
    }

    @Override
    public void updateAdressess(Adressess adressess) {
        adressessDAO.updateAdressess(adressess);

    }

    @Override
    public void deleteAdressess(Adressess adressess) {
        adressessDAO.deleteAdressess(adressess);
    }

    @Override
    public List<Adressess> getAllAdressesss() {
        return adressessDAO.getAllAdressesss();
    }
}
