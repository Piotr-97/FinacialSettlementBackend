package s18746.financialsettlementbackend.financialsettlementmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import s18746.financialsettlementbackend.financialsettelmentsmanager.repositories.FinancialSettlementRepository;

@SpringBootTest
public class FinancialSettlementFacadeTest {

    private final FinancialSettlementRepository financialSettlementRepository = new FinancialSettlementRepositoryTestImpl();


    @Test
    public void shouldCreateNewFinancialSettlement() {
//        //given
//        FinancialSettlementDto financialSettlementDto = new FinancialSettlementDto(
//                1L,
//                "Describe1",
//                BigDecimal.valueOf(100.00d),
//                "Company1",
//                "workUnderProjectName",
//                "Jan Kowalski",
//                1L,
//                LocalDateTime.now());
//        FinancialSettlementManagerFacade financialSettlementManagerFacade = new FinancialSettlementManagerConfiguration().financialSettlementManagerFacadeForTest(financialSettlementRepository);
//        //when
//        FinancialSettlement financialSettlement = financialSettlementManagerFacade.createNewSettlement(financialSettlementDto);
//        //then
//

    }

}

