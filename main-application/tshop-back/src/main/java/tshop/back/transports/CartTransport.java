package tshop.back.transports;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Роднуля on 11.04.2017.
 */
public class CartTransport {
    GoodsTransport goodsTransport;
    Integer quantity;

    public GoodsTransport getGoodsTransport() {
        return goodsTransport;
    }

    public void setGoodsTransport(GoodsTransport goodsTransport) {
        this.goodsTransport = goodsTransport;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
