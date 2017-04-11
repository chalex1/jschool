package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tshop.back.services.GoodsService;
import tshop.back.transports.CartTransport;
import tshop.back.transports.GoodsTransport;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Роднуля on 11.04.2017.
 */
@Component
@RestController
public class CartDataController {

    private static final String CLIENTS_CART = "ClientsCart";

    GoodsService goodsService;

    @Autowired

    public CartDataController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    //add goods
    @RequestMapping(path = "data/cart", method = RequestMethod.POST)
    public void addGoods(HttpSession session,
                         @RequestParam(name = "id") Long id,
                         @RequestParam(name = "quantity") Integer quantity) {
        initCart(session);
        changeCart(session, id, quantity);
    }


    //getcart
    @RequestMapping(path = "data/cart", method = RequestMethod.GET, produces = "application/json")
    public List<CartTransport> getCart(HttpSession session) {
        List<CartTransport> cartTransportList = new LinkedList<CartTransport>();
        if (session.getAttribute(CLIENTS_CART) != null) {
            HashMap<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute(CLIENTS_CART);
            for (Long id : cart.keySet()) {
                GoodsTransport gt = goodsService.getOne(id);
                if (gt != null&&cart.get(id)>0) {
                    CartTransport cartTransport = new CartTransport();
                    cartTransport.setGoodsTransport(gt);
                    cartTransport.setQuantity(1);//cart.get(id)
                    cartTransportList.add(cartTransport);
                }
            }
        }
        return cartTransportList;

    }
@RequestMapping(path="data/cart", method = RequestMethod.DELETE)
public void makeCartEmpty(HttpSession session){
    session.setAttribute(CLIENTS_CART, new HashMap<Long, Integer>());
}

    //init the cart

    private void initCart(HttpSession session) {
        if (session.getAttribute(CLIENTS_CART) == null) {
            session.setAttribute(CLIENTS_CART, new HashMap<Long, Integer>());
        }
    }

    private void changeCart(HttpSession session, Long id, Integer quantity) {
        HashMap<Long, Integer> map = ((HashMap<Long, Integer>) session.getAttribute(CLIENTS_CART));
        if (map.containsKey(id)) {
            map.put(id, map.get(id) + quantity);
        } else if (quantity > 0) map.put(id, quantity);
    }
}
