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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    Order order;

    public Adressess(String adressess) {
        this.adressess = adressess;
    }

    public String getAddr() {
        return adressess;
    }

    public void setAddr(String adressess) {
        this.adressess = adressess;
    }
}