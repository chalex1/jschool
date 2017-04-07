package tshop.back.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Goods;

import java.util.List;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Transactional
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    @Query("SELECT g FROM Goods AS g " +
            "WHERE g.name LIKE :name " +
            "AND g.price>=:priceFrom AND g.price <= :priceTo " +
            "AND g.quantity >= :quantityFrom " +
            "AND g.deleted = 0 ")
    List<Goods> findPageWithFilter(@Param("name") String name,
                                   @Param("priceFrom") long priceFrom,
                                   @Param("priceTo") long priceTo,
                                   @Param("quantityFrom") int quantityFrom,
                                   Pageable pageable);

    @Query("SELECT g FROM Goods AS g " +
            "WHERE g.deleted=0")
    List<Goods> findPage(Pageable pageable);


    @Query("SELECT g FROM Goods AS g " +
            "WHERE g.id = :id " +
            "AND g.deleted = 0")
    Goods findOne(@Param("id") long id);
}
