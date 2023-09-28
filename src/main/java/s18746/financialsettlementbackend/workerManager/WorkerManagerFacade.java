package s18746.financialsettlementbackend.workerManager;


import lombok.AllArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WorkerManagerFacade {



    private final WorkerService workerService;




}
