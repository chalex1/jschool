package tshop.back.entities;

import javax.persistence.*;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Table
@Entity
public class Client {

    /**
     * CREATE TABLE ESHOP.clients (
     * id NUMBER PRIMARY KEY,
     * password VARCHAR2(100),
     * id_address NUMBER CONSTRAINT id_address_fk REFERENCES ESHOP.addresses (id),
     * id_account NUMBER CONSTRAINT id_account_fk REFERENCES ESHOP.accounts (id)
     * );
     */
    @Id
    @Column
    @GeneratedValue
    long id;

    @Column
    long id_address;

    @Column
    long id_account;
}
