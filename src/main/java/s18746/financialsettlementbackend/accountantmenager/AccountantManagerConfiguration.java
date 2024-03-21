package s18746.financialsettlementbackend.accountantmenager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountantManagerConfiguration {


    @Bean
    public AccountantManagerFacade accountantManagerFacade(AnswerForSettlementRepository answerForSettlementRepository){
        FinancialSettlementResponseCreator financialSettlementResponseCreator = new FinancialSettlementResponseCreator();
        return new AccountantManagerFacade(financialSettlementResponseCreator,answerForSettlementRepository);
    }

    public AccountantManagerFacade accountantManagerFacadeForTest(AnswerForSettlementRepository answerForSettlementRepository,FinancialSettlementResponseCreator financialSettlementResponseCreator){
        return new AccountantManagerFacade(financialSettlementResponseCreator,answerForSettlementRepository);
    }
}
