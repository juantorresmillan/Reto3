package co.usar.ciclo3.ciclo3.web;

import co.usar.ciclo3.ciclo3.model.Category;
import co.usar.ciclo3.ciclo3.model.Gymmachine;
import co.usar.ciclo3.ciclo3.services.GymmachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class GymmachineController {

     @Autowired
    private GymmachineService gymmachineService;

     @GetMapping("/all")
     public List<Gymmachine> getGymmachine(){
         return gymmachineService.getAll();
     }

     @GetMapping("/{id}")
     public Optional<Gymmachine> getGymmachine(@PathVariable("id")int id){
         return gymmachineService.getGymmachine(id);
     }

     @PostMapping("/save")
     @ResponseStatus(HttpStatus.CREATED)
    public Gymmachine save (@RequestBody Gymmachine gym){
         return gymmachineService.save(gym);
     }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gymmachine update (@RequestBody Gymmachine gym){
         return gymmachineService.update(gym);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return gymmachineService.delete(id);
    }
}
