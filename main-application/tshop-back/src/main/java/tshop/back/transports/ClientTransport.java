package tshop.back.transports;

import tshop.back.entities.Client;

/**
 * Created by Роднуля on 01.04.2017.
 */
public class ClientTransport {

    long id;

    AddressTransport addressTransport;

    AccountTransport accountTransport;

    public ClientTransport() {
    }

    public ClientTransport(Client client) {
        this.id  = client.getId();
        this.addressTransport = new AddressTransport(client.getAddress());
        this.accountTransport = new AccountTransport(client.getAccount());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AddressTransport getAddressTransport() {
        return addressTransport;
    }

    public void setAddressTransport(AddressTransport addressTransport) {
        this.addressTransport = addressTransport;
    }

    public AccountTransport getAccountTransport() {
        return accountTransport;
    }

    public void setAccountTransport(AccountTransport accountTransport) {
        this.accountTransport = accountTransport;
    }
}
