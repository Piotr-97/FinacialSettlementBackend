package s18746.financialsettlementbackend.projectmanager;

import lombok.AllArgsConstructor;
import s18746.financialsettlementbackend.projectmanager.entities.Project;

import java.util.Optional;


@AllArgsConstructor
public class ProjectManagerFacade {



    private final ProjectRepository projectRepository;

    public Optional<Project> getProjectById(String id){
        return projectRepository.findById(id);
    }



}
