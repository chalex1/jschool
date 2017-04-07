package tshop.front.controllers.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tshop.back.services.AccountService;
import tshop.back.transports.AccountTransport;

import java.util.List;

/**
 * Created by Роднуля on 31.03.2017.
 */
@Component
@RestController
@RequestMapping(path = "data/accounts")
public class AccountDataController {


    private AccountService accountService;

    @Autowired
    public AccountDataController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<AccountTransport> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public AccountTransport createAccount(@RequestBody AccountTransport account){
        return accountService.createAccount(account);
    }
}
