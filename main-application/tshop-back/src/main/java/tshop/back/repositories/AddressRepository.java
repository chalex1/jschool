package tshop.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

import tshop.back.entities.Address;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {
}
