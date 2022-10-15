package co.usar.ciclo3.ciclo3.model.Report;

import co.usar.ciclo3.ciclo3.model.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CountClient {
    private Long total;
    private Client client;

    public CountClient(Long aLong, Client client) {
    }
}