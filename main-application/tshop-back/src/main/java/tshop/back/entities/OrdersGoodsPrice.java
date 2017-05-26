package tshop.back.entities;

import javax.persistence.*;

/**
 * Created by Роднуля on 21.05.2017.
 */
@Entity
@Table(name = "ESHOP.ORDERS_GOODS")
public class OrdersGoodsPrice {

@EmbeddedId
OrderGoodsId orderGoodsId;

    @Column
    Long price_on_moment;

    public OrderGoodsId getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(OrderGoodsId orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Long getPrice_on_moment() {
        return price_on_moment;
    }

    public void setPrice_on_moment(Long price_on_moment) {
        this.price_on_moment = price_on_moment;
    }
}
