package co.usar.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;

    @Column(length = 250)
    private String description;

    @OneToMany(cascade ={CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    public List<Gymmachine> machines;

}
