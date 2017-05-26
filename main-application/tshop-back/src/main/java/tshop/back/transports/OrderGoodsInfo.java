package tshop.back.transports;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Роднуля on 08.05.2017.
 */
public class OrderGoodsInfo {

    Long id = 0L;

    String paymentMethod="";


    String deliveryMethod="";


    String paymentStatus = "";


    String status = "";

    String createdAt = "";

    ClientTransport client;

    Map<String, Long> goodsRealPriceMap = new HashMap<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ClientTransport getClient() {
        return client;
    }

    public void setClient(ClientTransport client) {
        this.client = client;
    }

    public Map<String, Long> getGoodsRealPriceMap() {
        return goodsRealPriceMap;
    }

    public void setGoodsRealPriceMap(Map<String, Long> goodsRealPriceMap) {
        this.goodsRealPriceMap = goodsRealPriceMap;
    }
}
