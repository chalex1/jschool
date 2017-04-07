package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Роднуля on 07.04.2017.
 */
@Controller
@RequestMapping(path = "/categories")
public class CategoryController {
    @RequestMapping( method= RequestMethod.GET)
    public String home() {
        return "categories";
    }
}
