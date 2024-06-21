package s18746.financialsettlementbackend.projectmanager;

import lombok.AllArgsConstructor;
import s18746.financialsettlementbackend.projectmanager.exceptions.ProjectNotFoundException;
import s18746.financialsettlementbackend.projectmanager.dtos.ProjectDto;
import s18746.financialsettlementbackend.projectmanager.entities.Project;

import java.util.Optional;


@AllArgsConstructor
public class ProjectManagerFacade {

    private final WorkUnderProjectFacade workUnderProjectFacade;
    private final ProjectRepository projectRepository;

    public ProjectDto getProjectByProjectDto(ProjectDto projectDto) throws Exception {
        Optional<Project> project = projectRepository.findById(projectDto.id());
        if (project.isPresent()) {
            return mapProjectToDto(project.get());
        }
        throw new Exception("aaa");
    }

    public Project getProjectByid(String id) throws  ProjectNotFoundException{
        Long idLong = Long.parseLong(id);
        Optional<Project> project = projectRepository.findById(idLong);
        if (project.isPresent()){
            return project.get();
        }
        throw new ProjectNotFoundException("Project not found");
    }


    public Project addProject(ProjectDto projectDto) {
        Project newProject = mapDtoToProject(projectDto);
        return projectRepository.save(newProject);
    }


    public Project updateProject(ProjectDto updateProject) {
        Optional<Project> oldproject = projectRepository.findById(updateProject.id());
        if (oldproject.isPresent()) {
            Project changedProject = oldproject.get();
            if (changedProject.getName() != updateProject.projectName()) {
                changedProject.setName(updateProject.projectName());
            }
            return projectRepository.save(changedProject);
        }
        return null;
    }

    private Project mapDtoToProject(ProjectDto projectDto) {
        return null;
    }

    private ProjectDto mapProjectToDto(Project project) {
        return null;
    }


}
