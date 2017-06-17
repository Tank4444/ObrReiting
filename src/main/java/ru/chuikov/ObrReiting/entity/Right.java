package ru.chuikov.ObrReiting.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.*;

import javax.persistence.*;

@Entity
@Table(name="rights")
public class Right {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    public Right() {
    }

    public Right(String name) {
        this.name = name;
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
}
