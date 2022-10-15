package co.usar.ciclo3.ciclo3.web;

import co.usar.ciclo3.ciclo3.model.Category;
import co.usar.ciclo3.ciclo3.model.Client;
import co.usar.ciclo3.ciclo3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class ClientController {

     @Autowired
    private ClientService clientService;

     @GetMapping("/all")
     public List<Client> getClient(){
         return clientService.getAll();
     }

     @GetMapping("/{id}")
     public Optional<Client> getClient(@PathVariable("id")Integer id){
         return clientService.getClient(id);
     }

     @PostMapping("/save")
     @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody Client cli){
         return clientService.save(cli);
     }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update (@RequestBody Client cli){
        return clientService.update(cli);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return clientService.delete(id);
    }
}
