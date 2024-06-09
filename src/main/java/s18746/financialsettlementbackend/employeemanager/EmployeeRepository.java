package s18746.financialsettlementbackend.employeemanager;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Optional<Employee> findByFirstnameAndLastname(String firstname, String lastname);
    

}
