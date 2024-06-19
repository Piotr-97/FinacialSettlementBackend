package s18746.financialsettlementbackend.projectmanager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s18746.financialsettlementbackend.projectmanager.repositories.WorkUnderProjectRepository;

@Configuration
public class ProjectManagerConfiguration {


    @Bean
    public ProjectManagerFacade projectManagerFacade(ProjectRepository projectRepository, WorkUnderProjectRepository workUnderProjectRepository){
        WorkUnderProjectFacade workUnderProjectFacade = new WorkUnderProjectFacade(workUnderProjectRepository);
        return new ProjectManagerFacade(workUnderProjectFacade,projectRepository);
    }




}
