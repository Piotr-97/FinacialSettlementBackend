package s18746.financialsettlementbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {

    

}
