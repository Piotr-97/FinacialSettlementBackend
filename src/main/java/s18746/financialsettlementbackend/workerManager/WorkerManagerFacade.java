package s18746.financialsettlementbackend.workerManager;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class WorkerManagerFacade {

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



    public Worker updateWorker(Worker newWorker){
       Optional <Worker> workerOld = workerRepository.findById(newWorker.getId());

       if(workerOld.isPresent()){
           Worker updatedWorker = workerOld.get();
           //TODO ADD LOGIC
           workerRepository.save(updatedWorker);
       }
        return null;
    }

    public Worker addWorker(Worker worker){

       return workerRepository.save(worker);
    }







}
