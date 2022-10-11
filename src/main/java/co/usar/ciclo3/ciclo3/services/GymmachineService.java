package co.usar.ciclo3.ciclo3.services;

import co.usar.ciclo3.ciclo3.model.Gymmachine;
import co.usar.ciclo3.ciclo3.repository.GymmachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymmachineService {

    @Autowired
    private GymmachineRepository gymmachineRepository;

    public List<Gymmachine> getAll(){
        return gymmachineRepository.getAll();
    }
    public Optional<Gymmachine> getGymmachine(int id){
        return gymmachineRepository.getGymmachine(id);
    }
    public Gymmachine save(Gymmachine gym){
        Integer id = gym.getId();
        if(id==null){
            return gymmachineRepository.save(gym);
        } else {
            Optional<Gymmachine> gymaux=gymmachineRepository.getGymmachine(gym.getId());
            if (gymaux.isEmpty()){
                return gymmachineRepository.save(gym);
            } else {
                return gym;
            }
        }
    }
}
