package s18746.financialsettlementbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.entity.Worker;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {


    Optional<Worker> findByFirstnameAndLastname(String firstname, String lastname);
    

}
