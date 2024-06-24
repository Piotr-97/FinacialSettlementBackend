package s18746.financialsettlementbackend.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.projectmanager.ProjectResponse;
import s18746.financialsettlementbackend.projectmanager.dtos.*;
import s18746.financialsettlementbackend.projectmanager.ProjectManagerFacade;
import s18746.financialsettlementbackend.projectmanager.entities.Project;
import s18746.financialsettlementbackend.projectmanager.exceptions.ClientNotFoundException;

import java.util.List;


@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectManagerContoller {


    private final ProjectManagerFacade projectManagerFacade;



    @PostMapping
    public ResponseEntity<?> addProject(ProjectRequest projectRequest ){
        try {
            projectManagerFacade.addProject(projectRequest);
            return  ResponseEntity.ok(new ProjectCodeResponse("success"));
        }catch (ClientNotFoundException clientNotFoundException){
            return ResponseEntity.badRequest().body(new ProjectCodeResponse(clientNotFoundException.getMessage()));
        }
    }

    @GetMapping
    public  ResponseEntity<?> getAllProjects(){
        List<ProjectResponse> allProjects = projectManagerFacade.getAllProjects();
        return ResponseEntity.ok(allProjects);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Project> getProjectByUuid(@PathVariable String uuid){
        Project projectByUuid = projectManagerFacade.getProjectByUuid(uuid);

        return  ResponseEntity.ok(projectByUuid);
    }


    @GetMapping("/works")
    public ResponseEntity<List<WorkUnderProjectDto>> getAllWorksUnderProjects(){
        return null;
    }

    @GetMapping("/works/{id}")
    public ResponseEntity<WorkUnderProjectDto> getWorkUnderProjectById(@PathVariable Long id){
        return null;
    }

    @PatchMapping("works")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto){
        return null;
    }

    @PostMapping("/works")
    public ResponseEntity<WorkUnderProjectDto> addNewWorkUnderProject(@RequestBody WorkUnderProjectDto workUnderProjectDto){
        return null;
    }

    @GetMapping("/clients")
    public ResponseEntity<?> getAllclients(){
        List<ClientResponse>  clients = projectManagerFacade.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/clients")
    public ResponseEntity<?> addNewClient(@RequestBody ClientRequest clientRequest){
        projectManagerFacade.addClient(clientRequest);
        return  ResponseEntity.ok(clientRequest);
    }














}
