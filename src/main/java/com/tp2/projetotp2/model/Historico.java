package com.tp2.projetotp2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_HISTORICO")
public class Historico {
    public enum OPERACAO {CRIAR, ATUALIZAR, APAGAR}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private OPERACAO operacao;
    private String tipo_dado;
    private String valor_velho;
    private String valor_novo;
    private java.sql.Timestamp data;
}