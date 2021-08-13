package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.Category;
import edu.miu.cs545.project.onlinestore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        Collection<Category> categories = categoryService.getAll();
        return new ResponseEntity<Collection<Category>>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) {

        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent())
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        return new ResponseEntity<>("Category does not exist", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getCategoryByName(@RequestParam("name") String name) {
        Optional<Category> category = categoryService.getCategoryByName(name);
        if (category.isPresent())
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        return new ResponseEntity<>("Category does not exist", HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);

        return new ResponseEntity<>("Category created", HttpStatus.CREATED);
    }

}
