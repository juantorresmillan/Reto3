package co.usar.ciclo3.ciclo3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 250)
    private String name;

    @Column(length = 45)
    private String password;

    @Column(length = 45)
    private String email;

}
