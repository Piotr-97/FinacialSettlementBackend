package s18746.financialsettlementbackend.financialsettelmentsmanager;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.workerManager.Employee;
@Repository
public interface FinancialSettlementRepository extends JpaRepository<FinancialSettlement,Long> {



}
