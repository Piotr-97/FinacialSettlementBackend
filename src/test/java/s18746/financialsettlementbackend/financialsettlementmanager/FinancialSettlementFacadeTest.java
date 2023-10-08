package s18746.financialsettlementbackend.financialsettlementmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import s18746.financialsettlementbackend.financialsettelmentsmanager.*;

@SpringBootTest
public class FinancialSettlementFacadeTest {

    private final FinancialSettlementRepository financialSettlementRepository = new FinancialSettlementRepositoryTestImpl();



    @Test
    public void shouldCreateNewFinancialSettlement(){
        //given
        SettlementGenerator settlementGenerator = new SettlementGenerator();
        FinancialSettlementManagerFacade financialSettlementManagerFacade = new FinancialSettlementManagerConfiguration().financialSettlementManagerFacadeForTest(financialSettlementRepository, settlementGenerator) ;



        //when
        FinancialSettlement financialSettlement = financialSettlementManagerFacade.createNewSettlement();


        //then


    }

}

