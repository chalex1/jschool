package tshop.back.transports;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Роднуля on 02.04.2017.
 */
public class GoodsTransport {
    long id;
    
    String model;
    
    long price;
    
    String enginetype;
    
    String color;
    
    String transmission;
    
    long weight;
    
    long volume;
    
    long quantity;
    
    boolean deleted;
    
    String brakefront;
    
    String brakerear;
    
    String suspensionfront;
    
    String suspensionrear;
    
    String tiresfront;
    
    String tiresrear;
    
    String dimensions;
    
    long seatheight;
    
    long wetweight;
    
    String warranty;
    
    String promodescription;

    List<Long> categories=new LinkedList<Long>();

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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
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

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }
}
