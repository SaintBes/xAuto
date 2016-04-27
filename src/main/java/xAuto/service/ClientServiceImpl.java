package xAuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xAuto.dao.ClientDAO;
import xAuto.domain.Client;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDAO clientDAO;

    @Override
    public Client addClient(Client client) {
        return clientDAO.createClient(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClient(int clientId) {
        return clientDAO.readClient(clientId);
    }

    @Override
    public void updateClient(Client client) {
        clientDAO.updateClient(client);

    }

    @Override
    public void deleteClient(Client client) {
        clientDAO.deleteClient(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }
}
