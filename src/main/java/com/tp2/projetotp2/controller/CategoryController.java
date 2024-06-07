package com.tp2.projetotp2.controller;

import com.tp2.projetotp2.model.Category;
import com.tp2.projetotp2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategory() {
        return categoryService.findAll();

    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }
}
