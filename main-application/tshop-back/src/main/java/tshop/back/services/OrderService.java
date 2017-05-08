package tshop.back.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Client;
import tshop.back.entities.Order;
import tshop.back.repositories.ClientRepository;
import tshop.back.repositories.GoodsRepository;
import tshop.back.repositories.OrdersRepository;
import tshop.back.transports.ClientTransport;
import tshop.back.transports.OrderInfo;
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

    Logger logger = LoggerFactory.getLogger(OrderService.class.getName());

    @Autowired
    public OrderService(OrdersRepository ordersRepository, ClientRepository clientRepository, GoodsRepository goodsRepository) {
        this.ordersRepository = ordersRepository;
        this.clientRepository = clientRepository;
        this.goodsRepository = goodsRepository;
    }

    public List<OrderInfo> getAllOrders(){
        logger.info("Orders view");
        return ordersRepository.findAll().stream().map(order -> {
          return orderToOrderTransport(order);
        }).collect(Collectors.toList());
    }

    public List<OrderInfo> findAllOrdersOfClient(String clientlogin){
        logger.info("Orders view");
        Client client = clientRepository.getClientByLogin(clientlogin);
        return ordersRepository.findByClient(client).stream().map(order -> {
            return orderToOrderTransport(order);
        }).collect(Collectors.toList());
    }

    public OrderInfo createOrder(OrderTransport transport){
        Order order = new Order();
        order.setPaymentMethod(transport.getPaymentMethod());
        order.setPaymentStatus(transport.getPaymentStatus());
        order.setDeliveryMethod(transport.getDeliveryMethod());
        order.setStatus(transport.getStatus());
        order.setClient(clientRepository.findOne(transport.getClientId()));
        order.setGoods(goodsRepository.findAll(transport.getGoodsIds()));
        order.setCreated_at(Instant.now());
        ordersRepository.save(order);

        logger.info("Order 's created", order);
        return orderToOrderTransport(ordersRepository.findOne(order.getId()));
    }

    private OrderInfo orderToOrderTransport(Order order){
        OrderInfo orderInfo = new OrderInfo();

        orderInfo.setDeliveryMethod(order.getDeliveryMethod());
        orderInfo.setPaymentMethod(order.getPaymentMethod());
        orderInfo.setPaymentStatus(order.getPaymentStatus());
        orderInfo.setStatus(order.getStatus());
        orderInfo.setCreatedAt(order.getCreated_at().toString());
        orderInfo.setClient(new ClientTransport(order.getClient()));
//        orderInfo.setGoodsIds(getIds(order));
        return  orderInfo;
    }

    private List<Long> getIds(Order order){
        return order.getGoods().stream().map(goods -> {
            return goods.getId();
        }).collect(Collectors.toList());
    }
}
