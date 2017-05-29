package tshop.back.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.*;
import tshop.back.exceptions.NotEnoughProducts;
import tshop.back.exceptions.NowSuchOrderAtDB;
import tshop.back.repositories.ClientRepository;
import tshop.back.repositories.GoodsRepository;
import tshop.back.repositories.OrdersGoodsPriceRepository;
import tshop.back.repositories.OrdersRepository;
import tshop.back.transports.ClientTransport;
import tshop.back.transports.OrderGoodsInfo;
import tshop.back.transports.OrderInfo;
import tshop.back.transports.OrderTransport;
import tshop.back.util.OrderStatus;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    OrdersGoodsPriceRepository goodsPriceRepository;

    Logger logger = LoggerFactory.getLogger(OrderService.class.getName());


    @Autowired
    public OrderService(OrdersRepository ordersRepository, ClientRepository clientRepository, GoodsRepository goodsRepository, OrdersGoodsPriceRepository goodsPriceRepository) {
        this.ordersRepository = ordersRepository;
        this.clientRepository = clientRepository;
        this.goodsRepository = goodsRepository;
        this.goodsPriceRepository = goodsPriceRepository;
    }


    private Sort orderBy() {
        return new Sort(Sort.Direction.DESC, "createdAt");
    }

    public List<OrderInfo> getAllOrders() {
        logger.info("Orders view");
        return ordersRepository.findAll(orderBy()).stream().map(order -> {
            return orderToOrderTransport(order);
        }).collect(Collectors.toList());
    }

    public List<OrderInfo> findAllOrdersOfClient(String clientlogin) {
        logger.info("Orders view");
        Client client = clientRepository.getClientByLogin(clientlogin);
        return ordersRepository.findByClient(client, orderBy()).stream().map(order -> {
            return orderToOrderTransport(order);
        }).collect(Collectors.toList());
    }


    public OrderInfo createOrder(OrderTransport transport) throws NotEnoughProducts {
        Order order = new Order();
        order.setPaymentMethod(transport.getPaymentMethod());
        order.setPaymentStatus(transport.getPaymentStatus());
        order.setDeliveryMethod(transport.getDeliveryMethod());
        order.setStatus(transport.getStatus());
        order.setClient(clientRepository.findOne(transport.getClientId()));
        List<Goods> goodsList = goodsRepository.findAll(transport.getGoodsIds());
        //checking amount
        for (Goods goods : goodsList) {
            if (goods.getQuantity() < 1)
                throw new NotEnoughProducts();
        }
        //changing quantity
        for (Goods goods : goodsList) {
            goods.setQuantity(goods.getQuantity() - 1);
        }
        goodsRepository.save(goodsList);

        order.setGoods(goodsList);
        order.setCreatedAt(Instant.now());
        order.setStatus(OrderStatus.PROCESS.toString());
        ordersRepository.save(order);

        //now save price on moment
        List<OrdersGoodsPrice> goodspriceList = goodsPriceRepository.getGoodsPriceByOrderId(order.getId());
        for (OrdersGoodsPrice ogp : goodspriceList) {
            for (Goods goods : goodsList) {
                if (goods.getId() == ogp.getOrderGoodsId().getId_goods()) {
                    ogp.setPrice_on_moment(goods.getPrice());
                    System.out.println(goods.getModel() + " " + goods.getPrice());
                }
            }
        }
        goodsPriceRepository.save(goodspriceList);
        logger.info("Prices setted to order on moment");
        logger.info("Order 's created", order);
        return orderToOrderTransport(ordersRepository.findOne(order.getId()));
    }

    public OrderInfo discardOrder(Long id) throws NowSuchOrderAtDB {
        Order order = findOrder(id);
        List<Goods> goodss = order.getGoods();
        //changing quantity
        for (Goods goods : goodss) {
            goods.setQuantity(goods.getQuantity() + 1);
        }
        goodsRepository.save(goodss);
        order.setStatus(OrderStatus.DISCARDED.toString());

        //clean up the goodsprice connection
        //looks like don't need it
//        List<OrdersGoodsPrice> ordersGoodsPriceList =goodsPriceRepository.getGoodsPriceByOrderId(order.getId());
//        goodsPriceRepository.delete(ordersGoodsPriceList);


        ordersRepository.save(order);
        return orderToOrderTransport(ordersRepository.findOne(order.getId()));
    }

    public OrderGoodsInfo getOrder(Long id) throws NowSuchOrderAtDB {
        List<OrdersGoodsPrice> ordersGoodsPriceList = goodsPriceRepository.getGoodsPriceByOrderId(id);

        return orderToOrderTransport(findOrder(id), ordersGoodsPriceList);
    }

    public OrderInfo saveOrder(OrderTransport transport) throws NowSuchOrderAtDB {
        Order order = findOrder(transport.getId());

        order.setStatus(transport.getStatus());
        order.setPaymentMethod(transport.getPaymentMethod());
        order.setDeliveryMethod(transport.getDeliveryMethod());
        ordersRepository.save(order);
        return orderToOrderTransport(ordersRepository.findOne(order.getId()));
    }

    private Order findOrder(long id) throws NowSuchOrderAtDB {
        Order order = ordersRepository.findOne(id);
        if (order == null) {
            throw new NowSuchOrderAtDB();
        }
        return order;
    }

    public OrderInfo payByOrder(Long orderId) {
        Order order = ordersRepository.findOne(orderId);
        order.setStatus(OrderStatus.PAID.toString());
        ordersRepository.save(order);
        return orderToOrderTransport(ordersRepository.findOne(order.getId()));

    }

    private OrderInfo orderToOrderTransport(Order order) {
        OrderInfo orderInfo = new OrderInfo();

        orderInfo.setId(order.getId());
        orderInfo.setDeliveryMethod(order.getDeliveryMethod());
        orderInfo.setPaymentMethod(order.getPaymentMethod());
        orderInfo.setPaymentStatus(order.getPaymentStatus());
        orderInfo.setStatus(order.getStatus());
        orderInfo.setCreatedAt(order.getCreatedAt().toString());
        orderInfo.setClient(new ClientTransport(order.getClient()));

        return orderInfo;
    }
    private OrderGoodsInfo orderToOrderTransport(Order order, List<OrdersGoodsPrice> goodsprice) {
        OrderGoodsInfo orderInfo = new OrderGoodsInfo();

        orderInfo.setId(order.getId());
        orderInfo.setDeliveryMethod(order.getDeliveryMethod());
        orderInfo.setPaymentMethod(order.getPaymentMethod());
        orderInfo.setPaymentStatus(order.getPaymentStatus());
        orderInfo.setStatus(order.getStatus());
        orderInfo.setCreatedAt(order.getCreatedAt().toString());
        orderInfo.setClient(new ClientTransport(order.getClient()));


        if (goodsprice != null) {
            Map<Long, Goods> goodsMap = new HashMap<>();
            for (Goods goods : order.getGoods()) {
                goodsMap.put(goods.getId(), goods);
            }
            Map<String, Long> goodspricemap = new HashMap<>();
            for (OrdersGoodsPrice gp : goodsprice) {
                String goodsmodel = goodsMap.get(gp.getOrderGoodsId().getId_goods()).getModel();
                Long goodsPrice = gp.getPrice_on_moment();
                goodspricemap.put(goodsmodel,goodsPrice);
            }
            orderInfo.setGoodsRealPriceMap(goodspricemap);
        }
        return orderInfo;
    }

    private List<Long> getIds(Order order) {
        return order.getGoods().stream().map(goods -> {
            return goods.getId();
        }).collect(Collectors.toList());
    }
}
