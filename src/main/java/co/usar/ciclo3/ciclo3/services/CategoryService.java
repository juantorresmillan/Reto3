package co.usar.ciclo3.ciclo3.services;

import co.usar.ciclo3.ciclo3.model.Admin;
import co.usar.ciclo3.ciclo3.model.Category;
import co.usar.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category cat) {
        Integer id = cat.getId();
        if (id == null) {
            return categoryRepository.save(cat);
        } else {
            Optional<Category> cataux = categoryRepository.getCategory(cat.getId());
            if (cataux.isEmpty()) {
                return categoryRepository.save(cat);
            } else {
                return cat;
            }
        }
    }

    public Category update(Category cat) {
        Integer id = cat.getId();
        if (id != null) {
            Optional<Category> cataux = categoryRepository.getCategory(cat.getId());
            if (!cataux.isEmpty()) {
                if (cat.getName() != null) {
                    cataux.get().setName(cat.getName());
                }
                if (cat.getDescription() != null) {
                    cataux.get().setDescription(cat.getDescription());
                                }
                return categoryRepository.save(cataux.get());
            }

        }
        return cat;
    }

    public boolean delete(int id) {
        boolean cat = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return cat;
    }
}
