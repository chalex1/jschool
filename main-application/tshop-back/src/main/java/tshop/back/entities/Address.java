package tshop.back.entities;

import javax.persistence.*;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Entity
@Table(name="addresses", schema = "ESHOP")
public class Address {
//    CREATE TABLE ESHOP.addresses (
//    id NUMBER PRIMARY KEY ,
//    country VARCHAR2(100),
//    city VARCHAR2(100),
//    postcode VARCHAR2(100),
//    street VARCHAR2(100),
//    home VARCHAR2(100),
//    flat VARCHAR2(100)
//);

    @Id
    @GeneratedValue
    @Column
    long id;

    @Column
    String country;

    @Column
    String city;

    @Column
    String postcode;

    @Column
    String street;

    @Column
    String home;

    @Column
    String flat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
