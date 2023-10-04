package s18746.financialsettlementbackend.financialsettelmentsmanager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinancialSettlementManagerConfiguration {


    @Bean
    public FinancialSettlementsManagerFacade financialSettlementsManagerFacade(FinancialSettlementRepository financialSettlementRepository){
       return new FinancialSettlementsManagerFacade(financialSettlementRepository);
    }

    public FinancialSettlementsManagerFacade financialSettlementsManagerFacadeForTest(FinancialSettlementRepository financialSettlementRepository)
    {
        return new FinancialSettlementsManagerFacade(financialSettlementRepository);

    }


}
