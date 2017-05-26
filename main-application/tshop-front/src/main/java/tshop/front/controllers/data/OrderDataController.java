package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tshop.back.exceptions.NotEnoughProducts;
import tshop.back.exceptions.NowSuchOrderAtDB;
import tshop.back.services.OrderService;
import tshop.back.transports.OrderGoodsInfo;
import tshop.back.transports.OrderInfo;
import tshop.back.transports.OrderTransport;

import java.util.List;

/**
 * Created by Роднуля on 03.04.2017.
 */
@Component
@RestController
@RequestMapping(path = "data/orders")
public class OrderDataController {

    @Autowired
    OrderService orderService;

    @RequestMapping(path = "/all",method = RequestMethod.GET, produces = "application/json")
    public List<OrderInfo> getOrders(){
        return orderService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<OrderInfo> getOrdersForCurrent()
    {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderService.findAllOrdersOfClient(principal.getUsername());
    }

    @RequestMapping( path = "/{id}",method = RequestMethod.GET, produces = "application/json")
    public OrderGoodsInfo getOrderDetailed(@PathVariable(value="id") Long id) throws NowSuchOrderAtDB {
        return orderService.getOrder(id);
    }

    @RequestMapping( path = "/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public OrderInfo discardOrder(@PathVariable(value="id") Long id) throws NowSuchOrderAtDB {
        return orderService.discardOrder(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public OrderInfo createOrder(@RequestBody OrderTransport orderTransport) throws NotEnoughProducts {
        return orderService.createOrder(orderTransport);
    }
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public OrderInfo saveOrder(@RequestBody OrderTransport orderTransport) throws NowSuchOrderAtDB {
        return orderService.saveOrder(orderTransport);
    }
}
