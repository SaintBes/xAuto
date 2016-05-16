package xAuto.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by admssa on 10.05.2016.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="addrId")
public class Adressess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addrId;

    private String adressess;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    Order order;

    public Adressess() {
    }

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

    @Override
    public String toString() {
        return  adressess + '\'';
    }
}