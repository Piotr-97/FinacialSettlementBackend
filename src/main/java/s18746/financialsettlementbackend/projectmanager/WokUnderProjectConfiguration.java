package s18746.financialsettlementbackend.projectmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s18746.financialsettlementbackend.projectmanager.repositories.WorkUnderProjectRepository;

@Configuration
public class WokUnderProjectConfiguration {



    @Bean
    public WorkUnderProjectFacade workUnderProjectFacade(WorkUnderProjectRepository workUnderProjectRepository){
        return new WorkUnderProjectFacade(workUnderProjectRepository);
    }
}
