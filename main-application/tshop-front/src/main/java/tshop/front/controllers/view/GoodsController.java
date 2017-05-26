package tshop.front.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Роднуля on 27.03.2017.
 */
@Controller
public class GoodsController {

    @RequestMapping( path={"/goods","/"}, method= RequestMethod.GET)
    public String home() {
        return "goods";
    }

    @RequestMapping(path="/goodsnew", method = RequestMethod.GET)
    public String goodsNew(){
        return "goodsnew";
    }

    @RequestMapping(path="/goodsdetailed", method = RequestMethod.GET)
    public String goodsDetailed(Model model, @RequestParam(name="id") Long id){
        model.addAttribute("id", id);
        return "goodsDetailed";
    }
    @RequestMapping(path="/goodsinfo", method = RequestMethod.GET)
    public String goodsInfo(Model model, @RequestParam(name="id") Long id){
        model.addAttribute("id", id);
        return "goodsInfo";
    }
}
