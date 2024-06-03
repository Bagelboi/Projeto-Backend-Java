package com.tp2.projetotp2.controller;

import com.tp2.projetotp2.model.Projeto;
import com.tp2.projetotp2.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("projeto")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @Cacheable(value = "projeto")
    @GetMapping()
    public List<Projeto> getAlunos() {
        return projetoService.findAll();

    }
    @PostMapping
    public Projeto createAluno(@RequestBody Projeto projeto) {

        return projetoService.save(projeto);
    }
}
