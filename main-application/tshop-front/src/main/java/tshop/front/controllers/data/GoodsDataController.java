package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tshop.back.services.GoodsService;
import tshop.back.transports.GoodsTransport;


import java.util.LinkedList;
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
                                        @RequestParam(name = "quantityFrom", required = false) Long quantityFrom,
                                        @RequestParam(name = "page", defaultValue = "1") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        List<GoodsTransport> goodsList = new LinkedList<>();
        if (name == null && priceFrom == null && priceTo == null && quantityFrom == null) {
            goodsList = goodsService.getAllGoodsPage(page, size);
        } else if (priceFrom == null && priceTo == null) {
            goodsList = goodsService.getGoodsPage(name, quantityFrom, page, size);
        } else {
            goodsList = goodsService.getGoodsPage(name, priceFrom, priceTo, quantityFrom, page, size);
        }
        return goodsList;
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET, produces = "application/json")
    public GoodsTransport getOne(@PathVariable(value = "id") Long id){
        return goodsService.getOne(id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, produces = "application/json", consumes = "application/json")
    public GoodsTransport createGoods(@RequestBody GoodsTransport transport) {
        return goodsService.saveGoods(transport);
    }
}
