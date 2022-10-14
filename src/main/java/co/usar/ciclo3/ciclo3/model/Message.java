package co.usar.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "message")
@Getter
@Setter

public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="message")
    private int idMessage;

    @Column(length = 250, nullable = false)
    private String messageText;

    @ManyToOne
    @JoinColumn(name="machineId", referencedColumnName = "id")
    @JsonIgnoreProperties({"messages","reservations", "client"})
    private Gymmachine machine;

    @ManyToOne
    @JoinColumn(name="clientId", referencedColumnName = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
}


