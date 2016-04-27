package xAuto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by admssa on 27.04.2016.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientId;

    private String clientName;
    private String clietnEmail;
    private String clientPhone;

    public Client() {
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClietnEmail() {
        return clietnEmail;
    }

    public void setClietnEmail(String clietnEmail) {
        this.clietnEmail = clietnEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }
}
