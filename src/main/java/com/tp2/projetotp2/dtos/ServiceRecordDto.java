package com.tp2.projetotp2.dtos;

import com.tp2.projetotp2.model.Project;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record ServiceRecordDto(String name, Long projectId, Double cost, String description){

}