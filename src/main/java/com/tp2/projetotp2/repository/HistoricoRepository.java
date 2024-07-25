package com.tp2.projetotp2.repository;

import com.tp2.projetotp2.model.Historico;
import com.tp2.projetotp2.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}