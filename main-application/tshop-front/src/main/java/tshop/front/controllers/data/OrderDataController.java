package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tshop.back.services.OrderService;
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

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public OrderInfo createOrder(@RequestBody OrderTransport orderTransport){
        return orderService.createOrder(orderTransport);
    }
}
