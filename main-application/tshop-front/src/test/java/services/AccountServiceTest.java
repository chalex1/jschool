package services;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tshop.back.entities.Account;
import tshop.back.repositories.AccountRepository;
import tshop.back.services.AccountService;
import tshop.front.WebInitializer;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by Роднуля on 13.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebInitializer.class})
public class AccountServiceTest {

    AccountService accountService;
    AccountRepository accountRepository;
    @org.junit.Before
    public void setUp() throws Exception {
        accountRepository = mock(AccountRepository.class);
         accountService = new AccountService(accountRepository);

    }

    @org.junit.Test
    public void getAllAccounts() throws Exception {
        List<Account> list =accountRepository.findAll();
        assertNotNull(list);
    }

}