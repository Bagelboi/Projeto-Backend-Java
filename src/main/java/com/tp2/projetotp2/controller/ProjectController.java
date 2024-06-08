package com.tp2.projetotp2.controller;

import com.tp2.projetotp2.model.Project;
import com.tp2.projetotp2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping()
    public ResponseEntity<List<Project>> getProjects() {
        return projectService.findAll();

    }
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {

        return projectService.save(project);
    }
    @GetMapping("{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return projectService.findById(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity excluirProject (@PathVariable Long id){
        return this.projectService.deleteById(id);
    }
    @PatchMapping("{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }
}
