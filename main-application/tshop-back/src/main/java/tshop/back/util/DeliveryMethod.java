package tshop.back.util;

/**
 * Created by Роднуля on 11.04.2017.
 */
public enum DeliveryMethod {
    DELIVERY("Delivery"),
    PICKUP("Pickup");

    private String name;

    DeliveryMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
