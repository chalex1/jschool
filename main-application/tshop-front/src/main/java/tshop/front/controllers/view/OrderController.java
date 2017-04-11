package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Роднуля on 08.04.2017.
 */
@Controller
public class OrderController {
    @RequestMapping(path = "/orders",method= RequestMethod.GET)
    public String getAllOrdersView(){
        return "orders";
    }

    @RequestMapping(path="/neworder", method = RequestMethod.GET)
    public String prepareOrder() {
        return "prepareOrder";
    }

    @RequestMapping(path="/orderdetailed", method = RequestMethod.GET)
    public String orderDetailed(Model model, @RequestParam(name = "id") Long id) {
        model.addAttribute("id",id);
        return "orderDetailed";
    }

}
