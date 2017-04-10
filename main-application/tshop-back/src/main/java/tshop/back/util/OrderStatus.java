package tshop.back.util;

/**
 * Created by Роднуля on 11.04.2017.
 */
public enum OrderStatus {
    PROJECT("Init"),
    ARRANGED("Arranged"),
    READY("Ready");
    String name;

    OrderStatus(String name) {
        this.name = name;
    }
}
