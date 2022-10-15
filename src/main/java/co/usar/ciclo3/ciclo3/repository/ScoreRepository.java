package co.usar.ciclo3.ciclo3.repository;

import co.usar.ciclo3.ciclo3.model.Score;
import co.usar.ciclo3.ciclo3.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public ScoreRepository(){
    }

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score p){
        return scoreCrudRepository.save(p);
    }
    public void delete (Score sco){
        scoreCrudRepository.delete(sco);
    }
}
