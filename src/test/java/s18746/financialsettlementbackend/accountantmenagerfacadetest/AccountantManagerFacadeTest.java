package s18746.financialsettlementbackend.accountantmenagerfacadetest;


import org.springframework.boot.test.context.SpringBootTest;
import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlementRepository;

@SpringBootTest
public class AccountantManagerFacadeTest {

    private final AnswerForSettlementRepository answerForSettlementRepository = new AccountantManagerRepositoryTestImpl();


}
