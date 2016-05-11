package xAuto.service;

import xAuto.domain.Adressess;

import java.util.List;

/**
 * Created by admssa on 11.05.2016.
 */
public interface AdressessService {

    Adressess addAdressess(Adressess adressess);
    Adressess getAdressess(int adressessId);
    void updateAdressess(Adressess adressess);
    void deleteAdressess(Adressess adressess);
    List<Adressess> getAllAdressesss();

}
