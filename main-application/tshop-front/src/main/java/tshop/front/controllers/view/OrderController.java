package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Роднуля on 08.04.2017.
 */
@Controller
public class OrderController {
    @RequestMapping(path = "/orders",method= RequestMethod.GET)
    public String getAllOrdersView(){
        return "orders";
    }

}
