package co.usar.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;


    private Date startDate;

    //*SimpleDateFormat parser=new SimpleDateFormat("DD/MM/YYYY");

    private Date devolutionDate;

    private String status="created";

    @ManyToOne
    @JoinColumn(name = "gymmachineId")
    @JsonIgnoreProperties("reservations")
    private Gymmachine machine;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;




}