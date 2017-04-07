package tshop.back.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Category;

import java.util.List;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("SELECT c FROM Category AS c " +
            "WHERE c.deleted = 0 ")
    List<Category> findPage(Pageable pageable);


    @Query("SELECT c FROM Category AS c " +
            "WHERE c.deleted = 0")
    List<Category> findAll();

}