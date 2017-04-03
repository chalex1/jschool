package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tshop.back.services.GoodsService;
import tshop.back.transports.GoodsTransport;


import java.util.List;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Component
@RestController
@RequestMapping(path = "data/goods")
public class GoodsRestController {

    private GoodsService goodsService;

    @Autowired
    public GoodsRestController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GoodsTransport> getList() {
        return goodsService.getAllGoods();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public GoodsTransport createGoods(@RequestBody GoodsTransport transport){
        return goodsService.createGoods(transport);
    }
}
