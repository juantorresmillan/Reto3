package co.usar.ciclo3.ciclo3.web;

import co.usar.ciclo3.ciclo3.model.Category;
import co.usar.ciclo3.ciclo3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class CategoryController {   
         


    rivate CategoryService categoryService;


    public List<Categor
        return categoryService.getAll() ;
        
    

    public Optional<Cate
        return categoryService.getCategory(id);  
        
    

    @ResponseStatus(HttpS
    public Category save (@RequestBody 
        return categorySrvice.save(cat); 
        
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update (@RequestBody Category cat)
    {     return categoryService.save(cat);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return categoryService.delete(id);
    }

}
