package tshop.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Account;
import tshop.back.repositories.AccountRepository;
import tshop.back.transports.AccountTransport;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Service
@Transactional
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public List<AccountTransport> getAllAccounts(){
//            List<AccountTransport> res = new LinkedList<AccountTransport>();
//            res.add(new AccountTransport());
//            AccountTransport at = new AccountTransport();
//            at.setEmail("email");
//            res.add(at);
//            return res;
        return accountRepository.findAll().stream().map(account -> {
            AccountTransport transport = new AccountTransport(account);
            return transport;
        }).collect(Collectors.toList());
    }

     AccountTransport getAccount(long id){
      Account account =accountRepository.findOne(id);

      AccountTransport transport  = new AccountTransport(account);
      return transport;
    }

    @Transactional
    public AccountTransport createAccount(AccountTransport atr){
        Account account = new Account();
        if(atr.getId()!=0){
            account.setId(atr.getId());
        }
        account.setName(atr.getName());
        account.setLogin(atr.getLogin());
        account.setEmail(atr.getEmail());
        account.setSurname(atr.getSurname());
        account.setBirthday(atr.getBirthday());
        account.setPassword(atr.getPassword());
        account.setType(atr.getType());


        accountRepository.save(account);


        return this.getAccount(account.getId());

    }
}
