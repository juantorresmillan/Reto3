package co.usar.ciclo3.ciclo3.services;

import co.usar.ciclo3.ciclo3.model.Score;
import co.usar.ciclo3.ciclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score sco){
        Integer id = sco.getId();
        if(id==null){
            return scoreRepository.save(sco);
        } else {
            Optional<Score> scoaux=scoreRepository.getScore(sco.getId());
            if (scoaux.isEmpty()){
                return scoreRepository.save(sco);
            } else {
                return sco;
            }
        }
    }
}
