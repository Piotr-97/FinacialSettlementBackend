package s18746.financialsettlementbackend.financialsettelmentsmanager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinancialSettlementManagerConfiguration {


    @Bean
    public FinancialSettlementManagerFacade financialSettlementManagerFacade(FinancialSettlementRepository financialSettlementRepository){
        SettlementCreator settlementCreator = new SettlementCreator();
       return new FinancialSettlementManagerFacade(financialSettlementRepository, settlementCreator);
    }

    public FinancialSettlementManagerFacade financialSettlementManagerFacadeForTest(FinancialSettlementRepository financialSettlementRepository,SettlementCreator settlementCreator)
    {
        return new FinancialSettlementManagerFacade(financialSettlementRepository,settlementCreator);
    }


}
