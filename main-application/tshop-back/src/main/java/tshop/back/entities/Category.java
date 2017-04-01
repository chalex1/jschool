package tshop.back.entities;

import javax.naming.Name;
import javax.persistence.*;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Entity
@Table(name = "categories", schema= "ESHOP")
public class Category {
    //    CREATE TABLE ESHOP.categories (
//    id NUMBER PRIMARY KEY ,
//    name VARCHAR2(100)
//);
    @Id
    @GeneratedValue
    @Column
    long id;

    @Column
    String name;

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
}
