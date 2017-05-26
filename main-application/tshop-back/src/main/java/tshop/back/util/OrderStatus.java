package tshop.back.util;

/**
 * Created by Роднуля on 11.04.2017.
 */
public enum OrderStatus {
    INIT("Init"),
    PROCESS("Process"),
    PAID("Paid"),
    DISCARDED("Discarded");
    String name;

    OrderStatus(String name) {
        this.name = name;
    }
}
