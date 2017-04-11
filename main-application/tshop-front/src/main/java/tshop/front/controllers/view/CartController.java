package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Роднуля on 11.04.2017.
 */
@Controller
public class CartController {
    @RequestMapping( path = "/cart",method= RequestMethod.GET)
    public String home() {
        return "cart";
    }
}
