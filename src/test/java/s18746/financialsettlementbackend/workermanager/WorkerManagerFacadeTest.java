package s18746.financialsettlementbackend.workermanager;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import s18746.financialsettlementbackend.workerManager.Worker;
import s18746.financialsettlementbackend.workerManager.WorkerManagerConfiguration;
import s18746.financialsettlementbackend.workerManager.WorkerManagerFacade;
import s18746.financialsettlementbackend.workerManager.WorkerRepository;
import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class WorkerManagerFacadeTest {


    WorkerRepository workerRepository = new WorkerRepositoryTestImpl();

    @Test
    public  void  shouldAddNewWorkerToRepository(){
        //given
        WorkerManagerFacade workerManagerFacade = new WorkerManagerConfiguration().workerManagerFacadeForTest(workerRepository);
        Worker worker = Worker.builder()
                .id(1L)
                .firstname("Marek")
                .lastname("Kowalski")
                .email("marek.kowalski@email.com")
                .birthdate(LocalDate.of(1997, Month.APRIL,12)).build();
        //when
        workerManagerFacade.addWorker(worker);
        //then
        assertEquals(worker,workerRepository.findById(1L).get() );
        assertEquals(workerRepository.findAll().size(),1);


    }



}
