package co.usar.ciclo3.ciclo3.web;

import co.usar.ciclo3.ciclo3.model.Admin;
import co.usar.ciclo3.ciclo3.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class AdminController {

     @Autowired
     private AdminService adminService;

     @GetMapping("/all")
     public List<Admin> getAdmin(){
          return adminService.getAll();
     }

     @GetMapping("/{id}")
     public Optional<Admin> getAdmin(@PathVariable("id")Integer id){
          return adminService.getAdmin(id);
     }

     @PostMapping("/save")
     @ResponseStatus(HttpStatus.CREATED)
     public Admin save (@RequestBody Admin adm){
          return adminService.save(adm);
     }

     @PutMapping("/update")
     @ResponseStatus(HttpStatus.CREATED)
     public Admin update (@RequestBody Admin adm){
          return adminService.update(adm);
     }

     @DeleteMapping("/{id}")
     @ResponseStatus(HttpStatus.NO_CONTENT)
     public boolean delete(@PathVariable Integer id) {
          return adminService.delete(id);
     }

}
