package tshop.back.entities;

import javax.persistence.*;

/**
 * Created by Роднуля on 28.03.2017.
 */
@Entity
@Table(name="goods", schema="ESHOP")
public class Goods {


    @Id
    @GeneratedValue
    @Column
    long id;

    @Column
    String name;

    @Column
    long price;

    @Column
    String parameter1;

    @Column
    String parameter2;

    @Column
    String parameter3;

    @Column
    long weight;

    @Column
    long volume;

    @Column
    long quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    public long getWeight() {
        return weight;
    }

    public void setVeight(long weight) {
        this.weight = weight;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
