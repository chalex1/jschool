package tshop.back.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Роднуля on 28.03.2017.
 */
@Entity
@Table(name = "ESHOP.GOODS")
public class Goods {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column
    long id;
    @Column
    String model;
    @Column
    long price;
    @Column
    String enginetype;
    @Column
    String color;
    @Column
    String transmission;
    @Column
    long weight;
    @Column
    long volume;
    @Column
    long quantity;
    @Column
    long deleted;
    @Column
    String brakefront;
    @Column
    String brakerear;
    @Column
    String suspensionfront;
    @Column
    String suspensionrear;
    @Column
    String tiresfront;
    @Column
    String tiresrear;
    @Column
    String dimensions;
    @Column
    long seatheight;
    @Column
    long wetweight;
    @Column
    String warranty;
    @Column
    String promodescription;


    @Column
    @ManyToMany
    @JoinTable(name = "ESHOP.GOODS_CATEGORIES",
            joinColumns = {@JoinColumn(name = "ID_GOODS")},
            inverseJoinColumns = {@JoinColumn(name = "ID_CATEGORY")})
    List<Category> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getEnginetype() {
        return enginetype;
    }

    public void setEnginetype(String enginetype) {
        this.enginetype = enginetype;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
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

    public long getDeleted() {
        return deleted;
    }

    public void setDeleted(long deleted) {
        this.deleted = deleted;
    }

    public String getBrakefront() {
        return brakefront;
    }

    public void setBrakefront(String brakefront) {
        this.brakefront = brakefront;
    }

    public String getBrakerear() {
        return brakerear;
    }

    public void setBrakerear(String brakerear) {
        this.brakerear = brakerear;
    }

    public String getSuspensionfront() {
        return suspensionfront;
    }

    public void setSuspensionfront(String suspensionfront) {
        this.suspensionfront = suspensionfront;
    }

    public String getSuspensionrear() {
        return suspensionrear;
    }

    public void setSuspensionrear(String suspensionrear) {
        this.suspensionrear = suspensionrear;
    }

    public String getTiresfront() {
        return tiresfront;
    }

    public void setTiresfront(String tiresfront) {
        this.tiresfront = tiresfront;
    }

    public String getTiresrear() {
        return tiresrear;
    }

    public void setTiresrear(String tiresrear) {
        this.tiresrear = tiresrear;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public long getSeatheight() {
        return seatheight;
    }

    public void setSeatheight(long seatheight) {
        this.seatheight = seatheight;
    }

    public long getWetweight() {
        return wetweight;
    }

    public void setWetweight(long wetweight) {
        this.wetweight = wetweight;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getPromodescription() {
        return promodescription;
    }

    public void setPromodescription(String promodescription) {
        this.promodescription = promodescription;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
