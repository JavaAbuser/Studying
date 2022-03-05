package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "class")
public class Clas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "flower")
    private int flower;

    public Clas() {
    }

    public Clas(int flower) {
        this.flower = flower;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
