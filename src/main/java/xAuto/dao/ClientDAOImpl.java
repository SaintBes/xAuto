package xAuto.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xAuto.domain.Client;

import java.util.List;

/**
 * Created by admssa on 27.04.2016.
 */
@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    SessionFactory sessionFactory;



    @Override
    public Client createClient(Client client) {
        sessionFactory.getCurrentSession().save(client);
        return client;

    }

    @Override
    public Client readClient(int clientId) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, clientId);

    }

    @Override
    public void updateClient(Client client) {
        sessionFactory.getCurrentSession().update(client);
    }

    @Override
    public void deleteClient(Client client) {
        sessionFactory.getCurrentSession().delete(client);
    }

    @Override
    public List<Client> getAllClients() {
        return sessionFactory.getCurrentSession().createCriteria(Client.class).list();
    }
}
