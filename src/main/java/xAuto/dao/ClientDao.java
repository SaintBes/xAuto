package xAuto.dao;

import xAuto.domain.Client;

import java.util.List;

/**
 * Created by admssa on 10.05.2016.
 */
public interface ClientDAO {


        Client createClient(Client client);
        Client readClient(int clientId);
        void updateClient(Client client);
        void deleteClient(Client client);
        Client getClientByEmail(String email);
        List<Client> getAllClients();

    }

