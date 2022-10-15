package co.usar.ciclo3.ciclo3.web;

import co.usar.ciclo3.ciclo3.model.Gymmachine;
import co.usar.ciclo3.ciclo3.model.Message;
import co.usar.ciclo3.ciclo3.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class MessageController {

     @Autowired
    private MessageService messageService;

     @GetMapping("/all")
     public List<Message> getMessage(){
         return messageService.getAll();
     }

     @GetMapping("/{id}")
     public Optional<Message> getMessage(@PathVariable("id")Integer id){
         return messageService.getMessage(id);
     }

     @PostMapping("/save")
     @ResponseStatus(HttpStatus.CREATED)
    public Message save (@RequestBody Message mes){
         return messageService.save(mes);
     }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update (@RequestBody Message mes){
         return messageService.update(mes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return messageService.delete(id);
    }
}
