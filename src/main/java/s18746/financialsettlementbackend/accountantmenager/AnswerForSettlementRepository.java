package s18746.financialsettlementbackend.accountantmenager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerForSettlementRepository extends JpaRepository<AnswerForSettlement,Long> {

}
