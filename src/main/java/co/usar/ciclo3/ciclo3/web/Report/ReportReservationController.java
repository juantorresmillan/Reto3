package co.usar.ciclo3.ciclo3.web.Report;

import co.usar.ciclo3.ciclo3.model.Reservation;
import co.usar.ciclo3.ciclo3.model.report.CountClient;
import co.usar.ciclo3.ciclo3.model.report.CountStatus;
import co.usar.ciclo3.ciclo3.services.Report.ReportReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class ReportReservationController {

     @Autowired
    private ReportReservationService reportReservationService;

    @GetMapping("/report-clients")
    public List<CountClient> getReportTopClients(){
        return reportReservationService.getTopClients();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReportReservationsDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reportReservationService.getReservationPeriod(dateOne, dateTwo);
    }
    @GetMapping("/report-status")
    public CountStatus getReportStatusReservations(){
        return  reportReservationService.getReservationsStatus();
    }
    public ReportReservationController() {
    }

}

