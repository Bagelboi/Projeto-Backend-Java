package com.tp2.projetotp2.service;

import com.tp2.projetotp2.model.Project;
import com.tp2.projetotp2.repository.ProjectRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ResponseEntity<Project> save(Project project) {
        return ResponseEntity.ok(projectRepository.save(project));

    }

    public ResponseEntity<List<Project>> findAll() {

        return ResponseEntity.ok(projectRepository.findAll());
    }

    public ResponseEntity deleteById(@PathVariable Long id) {
        Project project = projectRepository.findById(id).orElse(null);

        if (project == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        }else{
            System.out.print(id);
            projectRepository.deleteById(id);
            return ResponseEntity.ok(project);
        }
    }
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        Project project = projectRepository.findById(id).orElse(null);

        if (project == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        }else{
            return ResponseEntity.ok(project);
        }
    }
    public Project updateProject(Long id, Project newProject) {
        return projectRepository.findById(id).map(project ->{
            project.setName(newProject.getName());
            project.setBudget(newProject.getBudget());
            project.setDescription(newProject.getDescription());
            return projectRepository.save(project);

        }).orElseGet(() -> {
            newProject.setId(id);
            return projectRepository.save(newProject);
        });
    }

}