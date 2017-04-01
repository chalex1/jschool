package tshop.front.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import java.util.Arrays;
import java.util.List;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Component
@RestController
@RequestMapping(path="data/goods")
public class GoodsRestController {


    @RequestMapping(method = RequestMethod.GET)
    public List<String> getList(){
      List<String>  res = Arrays.asList("1","2");
      return res;
    }
}
