package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tshop.back.services.ClientService;
import tshop.back.transports.ClientTransport;

import java.util.List;

/**
 * Created by Роднуля on 02.04.2017.
 */
@Component
@RestController
@RequestMapping(path = "data/clients")
public class ClientDataController {


    private ClientService clientService;

    @Autowired
    public ClientDataController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ClientTransport> getClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(path="/{id}",method = RequestMethod.GET, produces = "application/json")
    public ClientTransport getClient(@PathVariable(value = "id") Long id) {
        return clientService.findClient(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ClientTransport createAddress() {
        return clientService.createClient(1, 2);
    }
}
