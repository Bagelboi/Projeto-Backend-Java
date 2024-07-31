package com.tp2.projetotp2.service;

import com.tp2.projetotp2.model.Historico;
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

    @Autowired
    private HistoricoService historicoService;

    public ResponseEntity<Project> save(Project project) {
        Project saved_project = projectRepository.save(project);
        historicoService.newLog(Historico.OPERACAO.CRIAR, "Projeto", "ID: " + saved_project.getId().toString(), "");
        return ResponseEntity.ok(saved_project);
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
            historicoService.newLog(Historico.OPERACAO.APAGAR, "Projeto", "", "ID: " +   id.toString());
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
            historicoService.newLog(Historico.OPERACAO.ATUALIZAR, "Projeto", String.format("%s|%.2f|%s", newProject.getName(), newProject.getBudget(), newProject.getDescription()),
                    String.format("%s|%.2f|%s", project.getName(), project.getBudget(), project.getDescription()) );
            project.setName(newProject.getName());
            project.setBudget(newProject.getBudget());
            project.setDescription(newProject.getDescription());
            return projectRepository.save(project);

        }).orElseGet(() -> {
            newProject.setId(id);
            historicoService.newLog(Historico.OPERACAO.CRIAR, "Projeto",  "ID: " +  id.toString(), "");
            return projectRepository.save(newProject);
        });
    }

}