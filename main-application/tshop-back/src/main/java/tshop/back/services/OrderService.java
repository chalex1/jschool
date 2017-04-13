package tshop.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Order;
import tshop.back.repositories.ClientRepository;
import tshop.back.repositories.GoodsRepository;
import tshop.back.repositories.OrdersRepository;
import tshop.back.transports.OrderTransport;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Роднуля on 03.04.2017.
 */
@Service
@Transactional
public class OrderService {
    OrdersRepository ordersRepository;
    ClientRepository clientRepository;
    GoodsRepository goodsRepository;

    @Autowired
    public OrderService(OrdersRepository ordersRepository, ClientRepository clientRepository, GoodsRepository goodsRepository) {
        this.ordersRepository = ordersRepository;
        this.clientRepository = clientRepository;
        this.goodsRepository = goodsRepository;
    }

    public List<OrderTransport> getAllOrders(){
        return ordersRepository.findAll().stream().map(order -> {
          return orderToOrderTransport(order);
        }).collect(Collectors.toList());
    }

    public OrderTransport createOrder(OrderTransport transport){
        Order order = new Order();
        order.setPaymentMethod(transport.getPaymentMethod());
        order.setPaymentStatus(transport.getPaymentStatus());
        order.setDeliveryMethod(transport.getDeliveryMethod());
        order.setStatus(transport.getStatus());
        order.setClient(clientRepository.findOne(transport.getClientId()));
        order.setGoods(goodsRepository.findAll(transport.getGoodsIds()));
        order.setCreated_at(Instant.now());
        ordersRepository.save(order);
        return orderToOrderTransport(ordersRepository.findOne(order.getId()));
    }

    private OrderTransport orderToOrderTransport(Order order){
        OrderTransport orderTransport = new OrderTransport();
        orderTransport.setId(order.getId());
        orderTransport.setDeliveryMethod(order.getDeliveryMethod());
        orderTransport.setPaymentMethod(order.getPaymentMethod());
        orderTransport.setPaymentStatus(order.getPaymentStatus());
        orderTransport.setStatus(order.getStatus());
        orderTransport.setCreatedAt(order.getCreated_at().toString());
        orderTransport.setClientId(order.getClient().getId());
        orderTransport.setGoodsIds(getIds(order));
        return  orderTransport;
    }

    private List<Long> getIds(Order order){
        return order.getGoods().stream().map(goods -> {
            return goods.getId();
        }).collect(Collectors.toList());
    }
}
