package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.projectmanager.ProjectManagerFacade;
import s18746.financialsettlementbackend.projectmanager.dtos.ProjectDto;
import s18746.financialsettlementbackend.projectmanager.dtos.WorkUnderProjectDto;
import s18746.financialsettlementbackend.projectmanager.entities.Project;

import java.util.List;


@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectManagerContoller {


    private final ProjectManagerFacade projectManagerFacade;



    @PostMapping
    public ResponseEntity<Project> addProject(ProjectDto projectDto){

        return null;
    }

    @GetMapping
    public  ResponseEntity<List<ProjectDto>> getAllProjects(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectByid(@PathVariable Long id){
        return null;
    }


    @GetMapping("/works")
    public ResponseEntity<List<WorkUnderProjectDto>> getAllWorksUnderProjects(){
        return null;
    }

    @GetMapping("/works/{id}")
    public ResponseEntity<WorkUnderProjectDto> getWorkUnderProjectById(@PathVariable Long id){
        return null;
    }

    @PatchMapping
    public ResponseEntity<ProjectDto> updateProject(ProjectDto projectDto){
        return null;
    }

    @PostMapping("/works")
    public ResponseEntity<WorkUnderProjectDto> addNewWorkUnderProject(@RequestBody WorkUnderProjectDto workUnderProjectDto){
        return null;
    }














}
