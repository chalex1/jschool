package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import tshop.back.exceptions.LoginAlreadyInUse;
import tshop.back.services.AccountService;
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
    private AccountService accountService;

    @Autowired
    public ClientDataController(ClientService clientService, AccountService accountService) {
        this.clientService = clientService;
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ClientTransport> getClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(path = "/current", method = RequestMethod.GET, produces = "application/json")
    public ClientTransport getClient() {
        ClientTransport result = new ClientTransport();
        Object canbeuser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (canbeuser instanceof User) {
            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            result = clientService.findClient(principal.getUsername());
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ClientTransport saveNewClient(@RequestBody ClientTransport clientTransport) throws LoginAlreadyInUse {
        if (accountService.checkOnPossibleLogin(clientTransport.getAccountTransport().getLogin()) == false) {
            throw new LoginAlreadyInUse();
        }
        return clientService.saveClient(clientTransport);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ClientTransport saveClient(@RequestBody ClientTransport clientTransport) {
        return clientService.saveClient(clientTransport);
    }
}
