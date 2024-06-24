package s18746.financialsettlementbackend.projectmanager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s18746.financialsettlementbackend.projectmanager.repositories.AddressRepository;
import s18746.financialsettlementbackend.projectmanager.repositories.ClientRepository;
import s18746.financialsettlementbackend.projectmanager.repositories.WorkUnderProjectRepository;

@Configuration
public class ProjectManagerConfiguration {


    @Bean
    public ProjectManagerFacade projectManagerFacade(ProjectRepository projectRepository, WorkUnderProjectRepository workUnderProjectRepository, ClientRepository clientRepository, AddressRepository addressRepository){
        WorkUnderProjectFacade workUnderProjectFacade = new WorkUnderProjectFacade(workUnderProjectRepository);
        return new ProjectManagerFacade(workUnderProjectFacade,projectRepository,clientRepository, addressRepository);
    }




}
