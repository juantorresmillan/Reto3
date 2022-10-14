package co.usar.ciclo3.ciclo3.repository;

import co.usar.ciclo3.ciclo3.model.Reservation;
import co.usar.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public ReservationRepository(){
    }

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation res){
        return reservationCrudRepository.save(res);
    }

    public void delete (Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
}
