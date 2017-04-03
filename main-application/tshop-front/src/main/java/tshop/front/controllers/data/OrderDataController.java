package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tshop.back.services.OrderService;
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

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<OrderTransport> getOrders(){
        return orderService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public OrderTransport createOrder(@RequestBody OrderTransport orderTransport){
        return orderService.createOrder(orderTransport);
    }
}
