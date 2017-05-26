package tshop.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tshop.back.entities.Client;
import tshop.back.entities.OrderGoodsId;
import tshop.back.entities.OrdersGoodsPrice;

import java.util.List;

/**
 * Created by Роднуля on 21.05.2017.
 */
public interface OrdersGoodsPriceRepository extends JpaRepository<OrdersGoodsPrice, OrderGoodsId> {

    @Query("select p from OrdersGoodsPrice as p where p.orderGoodsId.id_order = :id_order")
    List<OrdersGoodsPrice> getGoodsPriceByOrderId(@Param("id_order") Long id_order);
}
