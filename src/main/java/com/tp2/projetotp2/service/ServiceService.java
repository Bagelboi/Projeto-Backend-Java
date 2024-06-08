package com.tp2.projetotp2.service;

import com.tp2.projetotp2.dtos.ServiceRecordDto;
import com.tp2.projetotp2.model.Project;
import com.tp2.projetotp2.model.Servicee;
import com.tp2.projetotp2.repository.ProjectRepository;
import com.tp2.projetotp2.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;
    private ProjectRepository projectRepository;

    public ServiceService(ServiceRepository serviceRepository, ProjectRepository projectRepository)
    {
        this.serviceRepository = serviceRepository;
        this.projectRepository = projectRepository;
    }

    @Transactional
    public ResponseEntity<Servicee> save(ServiceRecordDto serviceDto){
        Servicee service = new Servicee();
        System.out.println(serviceDto.projectId());
        service.setName(serviceDto.name());
        service.setProject(projectRepository.findById(serviceDto.projectId()).orElse(null));
        service.setCost(serviceDto.cost());
        service.setDescription(serviceDto.description());
        if (service.getProject() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        }
        return ResponseEntity.ok(serviceRepository.save(service));
    }
    public ResponseEntity<List<Servicee>> getAllService() {
        return ResponseEntity.ok(serviceRepository.findAll());
    }

    public ResponseEntity<List<Servicee>> getAllServicesByProjectId(@PathVariable Long projectId) {

        System.out.println(projectId);
        return ResponseEntity.ok(serviceRepository.findAllByProjectId(projectId));
    }


    public ResponseEntity<Servicee> findById(@PathVariable Long id) {
        Servicee service = serviceRepository.findById(id).orElse(null);

        if (service == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        }else{
            return ResponseEntity.ok(service);
        }
    }
    public ResponseEntity deleteById(@PathVariable Long id) {
        Servicee service = serviceRepository.findById(id).orElse(null);

        if (service == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        }else{
            projectRepository.deleteById(id);
            return ResponseEntity.ok(service);
        }
    }
}
