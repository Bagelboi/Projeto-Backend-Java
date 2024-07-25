package com.tp2.projetotp2.controller;

import com.tp2.projetotp2.model.Historico;
import com.tp2.projetotp2.model.Project;
import com.tp2.projetotp2.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("historico")
public class HistoricoController {
    @Autowired
    HistoricoService historicoService;

    @GetMapping
    public ResponseEntity<List<Historico>> getHistorico() {
        return ResponseEntity.ok(historicoService.getAll());
    }
}
