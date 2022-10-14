package co.usar.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date devolutionDate;

    @Column(nullable = false)
    private String status="created";

    @ManyToOne
    @JoinColumn(name = "gymmachineId", referencedColumnName = "id")
    @JsonIgnoreProperties("reservations")
    private Gymmachine machine;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
}