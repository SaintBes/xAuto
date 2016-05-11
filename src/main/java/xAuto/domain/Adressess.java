package xAuto.domain;

import javax.persistence.*;

/**
 * Created by admssa on 10.05.2016.
 */
@Entity
public class Adressess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addrId;

    private String adressess;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    Order order;


    public Adressess(String adressess) {
        this.adressess = adressess;
    }

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getAdressess() {
        return adressess;
    }

    public void setAdressess(String adressess) {
        this.adressess = adressess;
    }
}