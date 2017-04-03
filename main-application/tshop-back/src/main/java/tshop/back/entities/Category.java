package tshop.back.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.naming.Name;
import javax.persistence.*;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Entity
@Table(name = "ESHOP.CATEGORIES")
public class Category {

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
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
