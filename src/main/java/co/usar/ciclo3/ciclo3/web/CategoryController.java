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
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.POST })
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategory() {

        return categoryService.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id) {
        return categoryService.getCategory(id);

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c) {
        return categoryService.save(c);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category ct) {

        return categoryService.actualizarCategory(ct);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {

        return categoryService.delete(id);

    }

}
