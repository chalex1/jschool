package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String prepareOrder(Model model, @RequestParam(name = "id") String id)
    {model.addAttribute("id", id);
        return "prepareOrder";
    }

    @RequestMapping(path="/orderdetailed", method = RequestMethod.GET)
    public String orderDetailed(Model model, @RequestParam(name = "id") Long id) {
        model.addAttribute("id",id);
        return "orderDetailed";
    }


    @RequestMapping(path="/orderinfo", method = RequestMethod.GET)
    public String orderInfo(Model model, @RequestParam(name = "id") Long id) {
        model.addAttribute("id",id);
        return "orderInfo";
    }
//

}
