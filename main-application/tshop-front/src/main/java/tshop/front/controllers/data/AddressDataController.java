package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tshop.back.services.AddressService;
import tshop.back.transports.AddressTransport;

import java.util.List;

/**
 * Created by Роднуля on 02.04.2017.
 */
@Component
@RestController
@RequestMapping(path = "data/addresses")
public class AddressDataController {

    AddressService addressService;

    @Autowired
    public AddressDataController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<AddressTransport> getAddresses(){
        return addressService.getAllAddresses();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public AddressTransport createAddress(@RequestBody AddressTransport address){
        return addressService.createAddress(address);
    }
}
