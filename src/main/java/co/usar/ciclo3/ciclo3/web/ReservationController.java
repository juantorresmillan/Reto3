package co.usar.ciclo3.ciclo3.web;

import co.usar.ciclo3.ciclo3.model.Reservation;
import co.usar.ciclo3.ciclo3.model.report.CountClient;
import co.usar.ciclo3.ciclo3.model.report.CountStatus;
import co.usar.ciclo3.ciclo3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class ReservationController {

     @Autowired
    private ReservationService reservationService;

     @GetMapping("/all")
     public List<Reservation> getReservation(){
         return reservationService.getAll();
     }

     @GetMapping("/{id}")
     public Optional<Reservation> getReservation(@PathVariable("id")Integer id){
         return reservationService.getReservation(id);
     }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation res){
         return reservationService.save(res);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update (@RequestBody Reservation res){
         return reservationService.update(res);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return reservationService.delete(id);
    }

    //*    @PostMapping("/all")
//*    @ResponseStatus(HttpStatus.CREATED)
//*    public List<Reservation> list2() {
//*        return (List<Reservation>) reservationService.findAll();
//*    }

    //*    @GetMapping("/report-clients")
//*    public List<CountClient> getReportTopClients(){
//*        return reservationService.getTopClients();
//*    }
//*    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
//*    public List<Reservation> getReportReservationsDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
//*        return reservationService.getReservationPeriod(dateOne, dateTwo);
//*    }
//*    @GetMapping("/report-status")
//*    public CountStatus getReportStatusReservations(){
//*        return  reservationService.getReservationsStatus();
//*    }
//*    public ReservationService() {
//*    }
}

