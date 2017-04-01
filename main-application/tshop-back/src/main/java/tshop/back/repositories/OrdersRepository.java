package tshop.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Order;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Transactional
public interface OrdersRepository extends JpaRepository<Order, Long> {
}