package tshop.back.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Роднуля on 30.03.2017.
 */

@Entity
@Table(name = "ESHOP.CLIENTS")
public class Client {

    @Id
    @Column
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ACCOUNT")
    Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ADDRESS")
    Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
