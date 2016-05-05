package xAuto.service;

import xAuto.domain.Client;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
public interface ClientService {

    Client addClient(Client client);
    Client getClient(int clientId);
    void updateClient(Client client);
    void deleteClient(Client client);
    List<Client> getAllClients();
    Client getClientByEmail(String email);
}
