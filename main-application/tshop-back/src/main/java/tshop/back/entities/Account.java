package tshop.back.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Роднуля on 30.03.2017.
 */

@Entity
@Table(name = "ESHOP.ACCOUNTS")
public class Account {
    /**
     * CREATE TABLE ESHOP.accounts (
     * id NUMBER PRIMARY KEY ,
     * name VARCHAR2(100),
     * surname VARCHAR2(100),
     * login VARCHAR2(100),
     * password VARCHAR2(100),
     * email VARCHAR2(100),
     * birthday VARCHAR2(100)
     * );
     */

    @Id
    @Column
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    long id;


    @Column
    String name;

    @Column
    String surname;

    @Column
    String login;

    @Column
    String password;

    @Column
    String email;

    @Column
    String birthday;

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
