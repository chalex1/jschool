package tshop.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Goods;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Transactional
public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
