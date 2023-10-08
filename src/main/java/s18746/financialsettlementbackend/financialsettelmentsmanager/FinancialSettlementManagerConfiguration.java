package s18746.financialsettlementbackend.financialsettelmentsmanager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinancialSettlementManagerConfiguration {


    @Bean
    public FinancialSettlementManagerFacade financialSettlementManagerFacade(FinancialSettlementRepository financialSettlementRepository){
        SettlementGenerator settlementGenerator = new SettlementGenerator();
       return new FinancialSettlementManagerFacade(financialSettlementRepository, settlementGenerator);
    }

    public FinancialSettlementManagerFacade financialSettlementManagerFacadeForTest(FinancialSettlementRepository financialSettlementRepository, SettlementGenerator settlementGenerator)
    {
        return new FinancialSettlementManagerFacade(financialSettlementRepository, settlementGenerator);
    }


}
