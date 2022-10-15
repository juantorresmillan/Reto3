package co.usar.ciclo3.ciclo3.repository.crud;

import co.usar.ciclo3.ciclo3.model.Gymmachine;
import co.usar.ciclo3.ciclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
