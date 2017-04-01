package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Роднуля on 27.03.2017.
 */
@Controller
//@RestController
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping( method= RequestMethod.GET)
    public String home() {
        System.out.println("we re in the controller");
        return "goods";
    }
}
