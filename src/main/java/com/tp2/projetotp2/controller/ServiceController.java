package com.tp2.projetotp2.controller;

import com.tp2.projetotp2.dtos.ServiceRecordDto;
import com.tp2.projetotp2.model.Project;
import com.tp2.projetotp2.model.Servicee;
import com.tp2.projetotp2.service.ProjectService;
import com.tp2.projetotp2.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("servico")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @PostMapping
    public ResponseEntity<Servicee> createService(@RequestBody ServiceRecordDto serviceDto) {
        return serviceService.save(serviceDto);
    }
    @GetMapping
    public ResponseEntity<List<Servicee>> getAllServices(Long id){
        return serviceService.getAllService();
    }

    @GetMapping("{id}")
    public ResponseEntity<Servicee> getServiceById(Long projectId){
        return serviceService.findById(projectId);
    }
    @DeleteMapping("{id}")
    public ResponseEntity excluirService (@PathVariable Long id){
        return this.serviceService.deleteById(id);
    }
}
