package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Роднуля on 12.04.2017.
 */
@Controller
public class ClientController {

    @RequestMapping(path = "/client",method = RequestMethod.GET)
    public String clientDetailed(){
        return "clientDetailed";
    }

    @RequestMapping(path = "/clientnew",method = RequestMethod.GET)
    public String clientNew(){
        return "clientNew";
    }
}
