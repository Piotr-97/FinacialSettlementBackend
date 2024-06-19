package s18746.financialsettlementbackend.financialsettelmentsmanager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import java.util.List;
import java.util.Optional;

@Repository
public interface FinancialSettlementRepository extends JpaRepository<FinancialSettlement,Long> {

    List<FinancialSettlement> findAllByEmployeeId(Long employee_id);
    Optional<FinancialSettlement> findFinancialSettlementByUuid(String uuid);




}
