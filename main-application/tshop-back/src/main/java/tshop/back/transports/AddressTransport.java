package tshop.back.transports;

import tshop.back.entities.Address;

import javax.persistence.Column;

/**
 * Created by Роднуля on 01.04.2017.
 */
public class AddressTransport {
    long id;

    String country = "";


    String city= "";


    String postcode= "";


    String street= "";


    String home= "";


    String flat= "";

    public AddressTransport() {
    }

    public AddressTransport(Address address) {
        this.id = address.getId();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.postcode = getPostcode();
        this.street = getStreet();
        this.home = getHome();
        this.flat = getFlat();
    }

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
