package com.tp2.projetotp2.service;

import com.tp2.projetotp2.model.Projeto;
import com.tp2.projetotp2.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto save(Projeto aluno) {
        return projetoRepository.save(aluno);

    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

}
