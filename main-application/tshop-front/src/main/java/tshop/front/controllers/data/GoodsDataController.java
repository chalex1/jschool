package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tshop.back.services.GoodsService;
import tshop.back.transports.GoodsTransport;


import java.util.List;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Component
@RestController
@RequestMapping(path = "data/goods")
public class GoodsDataController {

    private GoodsService goodsService;

    @Autowired
    public GoodsDataController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GoodsTransport> getList(@RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "priceFrom", required = false) Long priceFrom,
                                        @RequestParam(name = "priceTo", required = false) Long priceTo,
                                        @RequestParam(name = "quantityFrom", required = false) Integer quantityFrom,
                                        @RequestParam(name = "page", defaultValue = "1") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size
                                        ) {
        if(name==null&&priceFrom==null&&priceTo==null&&quantityFrom==null){
            return goodsService.getAllGoodsPage(page,size);
        }
        return goodsService.getGoodsPage(name, quantityFrom, page, size);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public GoodsTransport createGoods(@RequestBody GoodsTransport transport) {
        return goodsService.createGoods(transport);
    }
}
