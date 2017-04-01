package tshop.back.entities;

import javax.persistence.*;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Table(name = "orders", schema = "ESHOP")
@Entity
public class Order {
    /**
     * CREATE TABLE ESHOP.orders (
     * id NUMBER PRIMARY KEY ,
     * payment_method VARCHAR2(100),
     * delivery_method VARCHAR2(100),
     * payment_status VARCHAR2(100),
     * status VARCHAR2(100),
     * id_client NUMBER CONSTRAINT id_client_fk REFERENCES ESHOP.clients (id)
     * );
     */

    @Id
    @Column
    @GeneratedValue
    long id;

    @Column(name = "payment_method")
    String paymentMethod;

    @Column(name = "delivery_method")
    String deliveryMethod;

    @Column(name = "payment_status")
    String paymentStatus;

    @Column(name = "status")
    String status;

    @Column(name = "id_client")
    long idClient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }
}
