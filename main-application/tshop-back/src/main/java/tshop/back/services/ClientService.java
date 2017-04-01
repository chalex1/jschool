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

    public ClientService(ClientRepository clientRepository, AccountRepository accountRepository, AddressRepository addressRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
    }

    @Autowired


    @Transactional
    public List<ClientTransport> getAllClients(){
        return clientRepository.findAll().stream().map(client -> {
            ClientTransport transport = new ClientTransport();
            transport.setId(client.getId());
            transport.setAccountTransport(new AccountTransport(client.getAccount()));
            transport.setAddressTransport(new AddressTransport(client.getAddress()));
            return transport;
        }).collect(Collectors.toList());
    }

    @Transactional
    public ClientTransport createClient(long idAddress, long idAccount){
       Address address =  addressRepository.findOne(idAddress);
       Account account = accountRepository.findOne(idAccount);
        Client client =  new Client();
        client.setAccount(account);
        client.setAddress(address);
        clientRepository.save(client);
        ClientTransport newclientTransport = new ClientTransport();
        newclientTransport.setId(client.getId());
        newclientTransport.setAccountTransport(new AccountTransport(account));
        newclientTransport.setAddressTransport(new AddressTransport(address));
        return newclientTransport;
    }
}
