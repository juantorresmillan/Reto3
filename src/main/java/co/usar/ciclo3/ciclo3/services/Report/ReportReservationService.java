package co.usar.ciclo3.ciclo3.services.Report;

import co.usar.ciclo3.ciclo3.model.Reservation;
import co.usar.ciclo3.ciclo3.model.report.CountClient;
import co.usar.ciclo3.ciclo3.model.report.CountStatus;
import co.usar.ciclo3.ciclo3.repository.Report.ReportReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportReservationService {

    @Autowired
    private ReportReservationRepository reportReservationRepository;

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")

    public List<Object[]> countTotalReservationsByClients() {
        return reportReservationRepository.countTotalReservationsByClients();
    }

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo) {
        return reportReservationRepository.findAllByStartDateAfterAndDevolutionDateBefore(dateOne, dateTwo);
    }

    public List<Reservation> findAllByStatus(String status) {
        return reportReservationRepository.findAllByStatus(status);
    }

    public <S extends Reservation> S save(S entity) {
        return reportReservationRepository.save(entity);
    }

    public <S extends Reservation> Iterable<S> saveAll(Iterable<S> entities) {
        return reportReservationRepository.saveAll(entities);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        reportReservationRepository.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends Reservation> entities) {
        reportReservationRepository.deleteAll(entities);
    }

    public void deleteAll() {
        reportReservationRepository.deleteAll();
    }

    public List<Reservation> getReservationPeriod(Date a, Date b) {
        return reportReservationRepository.getReservationPeriod(a, b);
    }

    public List<Reservation> getReservationsByStatus(String status) {
        return reportReservationRepository.getReservationsByStatus(status);
    }

    public Optional<Reservation> findById(Integer integer) {
        return reportReservationRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return reportReservationRepository.existsById(integer);
    }

    public Iterable<Reservation> findAll() {
        return reportReservationRepository.findAll();
    }

    public Iterable<Reservation> findAllById(Iterable<Integer> integers) {
        return reportReservationRepository.findAllById(integers);
    }

    public long count() {
        return reportReservationRepository.count();
    }

    public void deleteById(Integer integer) {
        reportReservationRepository.deleteById(integer);
    }

    public void delete(Reservation entity) {
        reportReservationRepository.delete(entity);
    }

    public List<CountClient> getTopClients() {
        return reportReservationRepository.getTopClients();
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);

        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        if (a.before(b)) {
            return reportReservationRepository.getReservationPeriod(a, b);
        } else {
            return new ArrayList<>();
        }
    }

    public CountStatus getReservationsStatus() {
        List<Reservation> completed = reportReservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reportReservationRepository.getReservationsByStatus("cancelled");

        return new CountStatus((long) completed.size(), (long) cancelled.size());
    }
}