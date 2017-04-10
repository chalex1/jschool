package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Роднуля on 07.04.2017.
 */
@Controller
public class CategoryController {
    @RequestMapping( path = "/categories",method= RequestMethod.GET)
    public String home() {
        return "categories";
    }

    @RequestMapping( path = "/newcategory",method= RequestMethod.GET)
    public String newcategory() {
        return "newcategory";
    }

    @RequestMapping(path ="/categorydetailed", method=RequestMethod.GET)
    public String detailed(Model model, @RequestParam(name="id") String id, @RequestParam(name="name", required = false, defaultValue = "") String name){
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "categoryDetailed";
    }
}
