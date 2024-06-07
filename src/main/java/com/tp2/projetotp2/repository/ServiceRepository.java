package com.tp2.projetotp2.repository;

import com.tp2.projetotp2.model.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface ServiceRepository extends JpaRepository<Servicee, Long> {

    List<Servicee> findAllByProjectId(Long projectId);

}
