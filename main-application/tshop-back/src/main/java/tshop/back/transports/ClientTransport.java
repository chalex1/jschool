package tshop.back.transports;

/**
 * Created by Роднуля on 01.04.2017.
 */
public class ClientTransport {

    long id;

    AddressTransport addressTransport;

    AccountTransport accountTransport;

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
