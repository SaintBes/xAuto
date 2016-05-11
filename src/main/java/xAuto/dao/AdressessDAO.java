package xAuto.dao;

import xAuto.domain.Adressess;

import java.util.List;

/**
 * Created by admssa on 11.05.2016.
 */
public interface AdressessDAO {
    Adressess createAdressess(Adressess adressess);
    Adressess readAdressess(int adressessId);
    void updateAdressess(Adressess adressess);
    void deleteAdressess(Adressess adressess);
    List<Adressess> getAllAdressesss();
}
