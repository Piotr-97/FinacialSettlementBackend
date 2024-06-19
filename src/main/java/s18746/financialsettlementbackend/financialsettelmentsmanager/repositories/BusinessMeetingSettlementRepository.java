package s18746.financialsettlementbackend.financialsettelmentsmanager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.financialsettelmentsmanager.BusinessMeetingSettlement;

@Repository
public interface BusinessMeetingSettlementRepository extends JpaRepository<BusinessMeetingSettlement, Long> {
}
