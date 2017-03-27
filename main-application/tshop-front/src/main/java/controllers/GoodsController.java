package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Роднуля on 27.03.2017.
 */
@Controller
public class GoodsController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home() {
        return "home";
    }
}
