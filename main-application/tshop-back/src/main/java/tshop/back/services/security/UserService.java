package tshop.back.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Account;
import tshop.back.repositories.AccountRepository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Роднуля on 15.04.2017.
 */
@Service
@Transactional
public class UserService implements UserDetailsService {
    AccountRepository accountRepository;

    @Autowired
    public UserService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       Account account = accountRepository.findByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", login));
        }

        Collection<SimpleGrantedAuthority> userAuthorities = new ArrayList<>();
        SimpleGrantedAuthority clientAuthority = new SimpleGrantedAuthority("CLIENT");
        userAuthorities.add(clientAuthority);

        if (account.isAdmin()) {
            SimpleGrantedAuthority employeeAuthority = new SimpleGrantedAuthority("ADMIN");
            userAuthorities.add(employeeAuthority);
        }

        User userDetails = new User(account.getLogin(),account.getPassword(),userAuthorities);

        return userDetails;
    }
}
