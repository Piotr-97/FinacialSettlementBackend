package s18746.financialsettlementbackend.workerManager;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {


    Optional<Worker> findByFirstnameAndLastname(String firstname, String lastname);
    

}
