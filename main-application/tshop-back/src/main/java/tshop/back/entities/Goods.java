package tshop.back.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Роднуля on 28.03.2017.
 */
@Entity
@Table(name="ESHOP.GOODS")
public class Goods {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
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

    @Column
    long deleted;

    @Column
    @ManyToMany
    @JoinTable(name = "ESHOP.GOODS_CATEGORIES",
            joinColumns = {@JoinColumn(name = "ID_GOODS") },
            inverseJoinColumns = { @JoinColumn(name = "ID_CATEGORY") })
    List<Category> categories;

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

    public void setWeight(long weight) {
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


    public List<Category> getCategoryes() {
        return categories;
    }

    public void setCategoryes(List<Category> categoryes) {
        this.categories = categoryes;
    }

    public long getDeleted() {
        return deleted;
    }

    public void setDeleted(long deleted) {
        this.deleted = deleted;
    }
}
