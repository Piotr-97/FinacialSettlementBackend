package s18746.financialsettlementbackend.financialsettelmentsmanager;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialSettlementRepository extends JpaRepository<FinancialSettlement,Long> {

    List<FinancialSettlement> findAllByEmployeeId(Long employee_id);



}
