package s18746.financialsettlementbackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s18746.financialsettlementbackend.entity.Worker;
import s18746.financialsettlementbackend.repositories.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public Optional<Worker> getWorkerById(Long id){
        return  workerRepository.findById(id);
    }

    public Optional<Worker> getWorkerByFirstnameAndLastname(String firstname, String lastname) {
        return workerRepository.findByFirstnameAndLastname(firstname,lastname);
    }

    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();

    }

    public  Optional<Worker> deleteWorkerById(Long id){
        Optional<Worker> workerToDelete = workerRepository.findById(id);
        if(workerToDelete.isPresent()){
            workerRepository.delete(workerToDelete.get());
                return workerToDelete;
        }
        return workerToDelete;
    }




}
