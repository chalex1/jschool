package tshop.back.transports;

import tshop.back.entities.Account;

/**
 * Created by Роднуля on 30.03.2017.
 */
public class AccountTransport {
    long id;



    String name= "";


    String surname= "";


    String login;


    String password;


    String email= "";


    String birthday= "";

    public AccountTransport() {

    }

    public AccountTransport(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.surname = account.getSurname();
        this.login = account.getLogin();
        this.password = account.getPassword();
        this.email = account.getEmail();
        this.birthday = account.getBirthday();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
