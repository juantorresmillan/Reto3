package co.usar.ciclo3.ciclo3.web;

import co.usar.ciclo3.ciclo3.model.Score;
import co.usar.ciclo3.ciclo3.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class ScoreController {

     @Autowired
    private ScoreService scoreService;

     @GetMapping("/all")
     public List<Score> getScore(){
         return scoreService.getAll();
     }

     @GetMapping("/{id}")
     public Optional<Score> getScore(@PathVariable("id")Integer id){
         return scoreService.getScore(id);
     }

     @PostMapping("/save")
     @ResponseStatus(HttpStatus.CREATED)
    public Score save (@RequestBody Score sco){
         return scoreService.save(sco);
     }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update (@RequestBody Score sco){
         return scoreService.update(sco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return scoreService.delete(id);
    }
}
