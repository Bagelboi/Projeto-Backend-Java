package com.tp2.projetotp2.controller;

import com.tp2.projetotp2.model.Categoria;
import com.tp2.projetotp2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("categoria")
public class CategoriasController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public List<Categoria> getMateriais() {
        return categoriaService.findAll();

    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }
}
