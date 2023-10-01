package s18746.financialsettlementbackend.workerManager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerManagerConfiguration {


    @Bean
    public WorkerManagerFacade workerManagerFacade(WorkerRepository workerRepository){
        return new
                WorkerManagerFacade(workerRepository);
    }

    public WorkerManagerFacade workerManagerFacadeForTest(WorkerRepository workerRepository)
    {
        return new WorkerManagerFacade(workerRepository);

    }
}
