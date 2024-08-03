package s18746.financialsettlementbackend.accountantmenager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.projectmanager.entities.Project;

import java.util.Optional;

@Repository
public interface AnswerForSettlementRepository extends JpaRepository<AnswerForSettlement,Long> {

    public Optional<AnswerForSettlement> findAnswerForSettlementByUuid(String uuid);

}
