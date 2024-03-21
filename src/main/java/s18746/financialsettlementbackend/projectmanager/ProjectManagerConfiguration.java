package s18746.financialsettlementbackend.projectmanager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectManagerConfiguration {


    @Bean
    public ProjectManagerFacade projectManagerFacade(ProjectRepository projectRepository){
        RaportGenerator raportGenerator = new RaportGenerator();
        WorkUnderProjectFacade workUnderProjectFacade = new WorkUnderProjectFacade();
        return new ProjectManagerFacade(workUnderProjectFacade,projectRepository,raportGenerator);
    }




}
