package s18746.financialsettlementbackend.financialsettelmentsmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.financialsettelmentsmanager.TaxiSettlement;

@Repository
public interface TaxiSettlementRepository extends JpaRepository<TaxiSettlement, Long> {
}
