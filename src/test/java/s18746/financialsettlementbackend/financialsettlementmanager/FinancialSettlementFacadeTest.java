package s18746.financialsettlementbackend.financialsettlementmanager;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerConfiguration;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementRepository;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlementManagerFacade;
import s18746.financialsettlementbackend.financialsettelmentsmanager.SettlementCreator;

@SpringBootTest
public class FinancialSettlementFacadeTest {

    private final FinancialSettlementRepository financialSettlementRepository = new FinancialSettlementRepositoryTestImpl();



    @Test
    public void shouldCreateNewFinancialSettlement(){
        SettlementCreator settlementCreator = new SettlementCreator();
        FinancialSettlementManagerFacade financialSettlementManagerFacade = new FinancialSettlementManagerConfiguration().financialSettlementManagerFacadeForTest(financialSettlementRepository,settlementCreator) ;


         ;
    }

}
