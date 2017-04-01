package tshop.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Address;
import tshop.back.repositories.AddressRepository;
import tshop.back.transports.AddressTransport;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Роднуля on 01.04.2017.
 */
@Service
@Transactional
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public List<AddressTransport> getAllAddresses(){
        return addressRepository.findAll().stream().map(address -> {
            AddressTransport transport = new AddressTransport(address);
            return transport;
        }).collect(Collectors.toList());
    }

    @Transactional
    public AddressTransport createAddress(AddressTransport addressTransport){
        Address address = new Address();
        address.setCity(addressTransport.getCity());
        address.setCountry(addressTransport.getCountry());
        address.setFlat(addressTransport.getFlat());
        address.setHome(addressTransport.getHome());
        address.setStreet(addressTransport.getStreet());
        address.setPostcode(addressTransport.getPostcode());
        addressRepository.save(address);
        return new AddressTransport(addressRepository.findOne(address.getId()));
    }
}
