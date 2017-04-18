package tshop.front.controllers.view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Роднуля on 14.04.2017.
 */
@Controller
public class ErrorPagesController {
    @RequestMapping(path = "/notExistingPage", method = RequestMethod.GET)
    public String goToErrorPage(){
        return "notExistingPage";
    }

    @RequestMapping(path = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied(){
        return "accessDenied";
    }
}
