package co.usar.ciclo3.ciclo3.repository;

import co.usar.ciclo3.ciclo3.model.Gymmachine;
import co.usar.ciclo3.ciclo3.repository.crud.GymmachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GymmachineRepository {
    @Autowired
    private GymmachineCrudRepository gymmachineCrudRepository;

    public GymmachineRepository(){
    }

    public List<Gymmachine> getAll(){
        return (List<Gymmachine>) gymmachineCrudRepository.findAll();
    }
    public Optional<Gymmachine> getGymmachine(int id){
        return gymmachineCrudRepository.findById(id);
    }

    public Gymmachine save(Gymmachine gym){
        return gymmachineCrudRepository.save(gym);
    }

    public void delete (Gymmachine gym){
        gymmachineCrudRepository.delete(gym);
    }
}
