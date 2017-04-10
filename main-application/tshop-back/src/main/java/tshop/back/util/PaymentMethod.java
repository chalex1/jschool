package tshop.back.util;

/**
 * Created by Роднуля on 11.04.2017.
 */
public enum PaymentMethod {
   CASH("Cash"),
    CARD("Card");

    private String name;

    PaymentMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
