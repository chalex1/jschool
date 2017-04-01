package tshop.front.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tshop.back.services.AddressService;
import tshop.back.services.ClientService;
import tshop.back.transports.ClientTransport;

import java.util.List;

/**
 * Created by Роднуля on 02.04.2017.
 */
@Component
@RestController
@RequestMapping(path = "data/clients")
public class ClientRestController {


    private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ClientTransport> getClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ClientTransport createAddress() {
        return clientService.createClient(1, 2);
    }
}
