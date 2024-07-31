package com.tp2.projetotp2.service;

import com.tp2.projetotp2.model.Historico;
import com.tp2.projetotp2.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class HistoricoService {
    @Autowired
    private HistoricoRepository historicoRepository;

    public List<Historico> getAll() {
        return historicoRepository.findAll();
    }

    public Historico newLog(Historico.OPERACAO op, String tipo_dado, String valor_novo, String valor_velho) {
        Historico historico = new Historico();
        historico.setOperacao(op);
        historico.setTipo_dado(tipo_dado);
        historico.setValor_novo(valor_novo);
        historico.setValor_velho(valor_velho);
        historico.setData(new Timestamp(System.currentTimeMillis()));
        return historicoRepository.save(historico);
    }
}
