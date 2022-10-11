package co.usar.ciclo3.ciclo3.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
@Getter
@Setter

public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 250, nullable = false)
    private String message;

    @Column(length = 1, nullable = false)
    private int scores;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

}
