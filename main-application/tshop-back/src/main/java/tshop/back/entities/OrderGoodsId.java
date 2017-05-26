package tshop.back.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Роднуля on 21.05.2017.
 */
@Embeddable
public class OrderGoodsId implements Serializable {

    long id_order;

    long id_goods;

    public OrderGoodsId() {

    }

    public OrderGoodsId(long id_order, long id_goods) {
        this.id_order = id_order;
        this.id_goods = id_goods;
    }

    public long getId_order() {
        return id_order;
    }

    public void setId_order(long id_order) {
        this.id_order = id_order;
    }

    public long getId_goods() {
        return id_goods;
    }

    public void setId_goods(long id_goods) {
        this.id_goods = id_goods;
    }
}
