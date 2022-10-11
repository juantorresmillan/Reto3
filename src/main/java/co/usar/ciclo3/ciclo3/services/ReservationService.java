package co.usar.ciclo3.ciclo3.services;

import co.usar.ciclo3.ciclo3.model.Reservation;
import co.usar.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation res){
        Integer id = res.getId();
        if(id==null){
            return reservationRepository.save(res);
        } else {
            Optional<Reservation> resaux=reservationRepository.getReservation(res.getId());
            if (resaux.isEmpty()){
                return reservationRepository.save(res);
            } else {
                return res;
            }
        }
    }
}
