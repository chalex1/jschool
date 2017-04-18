package tshop.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Account;



/**
 * Created by Роднуля on 30.03.2017.
 */
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {


    @Transactional(readOnly = true)
    Account findByLogin (String login);


}
