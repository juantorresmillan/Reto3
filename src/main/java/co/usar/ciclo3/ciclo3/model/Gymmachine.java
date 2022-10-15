package co.usar.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "gymmachine")
@Getter
@Setter

public class Gymmachine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String brand;

    @Column(name = "years", length = 4)
    private int year;

    @Column(length = 250)
    private String description;


    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties({"machines","messages"})
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine","messages"})
    public List<Reservation> reservations;


}
