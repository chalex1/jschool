package tshop.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tshop.back.entities.Account;
import tshop.back.entities.Address;
import tshop.back.entities.Client;
import tshop.back.repositories.AccountRepository;
import tshop.back.repositories.AddressRepository;
import tshop.back.repositories.ClientRepository;
import tshop.back.transports.AccountTransport;
import tshop.back.transports.AddressTransport;
import tshop.back.transports.ClientTransport;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Роднуля on 02.04.2017.
 */
@Service
@Transactional
public class ClientService {
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;
    private AddressRepository addressRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, AccountRepository accountRepository, AddressRepository addressRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
    }

    public ClientTransport findClient(Long id) {
        return getClientTransport(clientRepository.findOne(id));
    }

    public ClientTransport findClient(String login) {
        return getClientTransport(clientRepository.getClientByLogin(login));
    }


//    public ClientTransport findClientByLogin(String login){
//        return getClientTransport(clientRepository.findOne(login));
//    }

    @Transactional
    public List<ClientTransport> getAllClients() {
        return clientRepository.findAll().stream().map(client -> {
            return getClientTransport(client);
        }).collect(Collectors.toList());
    }

    private ClientTransport getClientTransport(Client client) {
        ClientTransport transport = new ClientTransport();
        transport.setId(client.getId());
        transport.setAccountTransport(new AccountTransport(client.getAccount()));
        transport.setAddressTransport(new AddressTransport(client.getAddress()));
        return transport;
    }

    @Transactional
    public ClientTransport createClient(long idAddress, long idAccount) {
        Address address = addressRepository.findOne(idAddress);
        Account account = accountRepository.findOne(idAccount);
        Client client = new Client();
        client.setAccount(account);
        client.setAddress(address);
        clientRepository.save(client);
        return getClientTransport(client);
    }

    @Transactional
    public ClientTransport saveClient(ClientTransport transport){
        AccountTransport accountTransport = transport.getAccountTransport();
        Account account = accountRepository.findOne(accountTransport.getId());
        if(account==null){
            account = new Account();
        }
        account.setName(accountTransport.getName());
        account.setType(accountTransport.getType());
        account.setPassword(accountTransport.getPassword());
        account.setBirthday(accountTransport.getBirthday());
        account.setEmail(accountTransport.getEmail());
        account.setLogin(accountTransport.getLogin());
        account.setSurname(accountTransport.getSurname());
//        accountRepository.save(account);

        AddressTransport addressTransport = transport.getAddressTransport();
        Address address = addressRepository.findOne(addressTransport.getId());
        if(address==null){
            address=new Address();
        }
        address.setPostcode(addressTransport.getPostcode());
        address.setStreet(addressTransport.getStreet());
        address.setFlat(addressTransport.getFlat());
        address.setCountry(addressTransport.getCountry());
        address.setCity(addressTransport.getCity());
        address.setHome(addressTransport.getHome());
//        addressRepository.save(address);


        Client client= clientRepository.findOne(transport.getId());
        if(client==null){
            client=new Client();
        }
        client.setId(transport.getId());
        client.setAccount(account);
        client.setAddress(address);
        clientRepository.save(client);
        return getClientTransport(clientRepository.findOne(client.getId()));
    }
}
