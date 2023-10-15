package s18746.financialsettlementbackend.financialsettlementmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import s18746.financialsettlementbackend.financialsettelmentsmanager.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
public class FinancialSettlementFacadeTest {

    private final FinancialSettlementRepository financialSettlementRepository = new FinancialSettlementRepositoryTestImpl();


    @Test
    public void shouldCreateNewFinancialSettlement() {
        //given
        FinancialSettlementDto financialSettlementDto = new FinancialSettlementDto(
                "Describe1",
                BigDecimal.valueOf(100.00d),
                "Company1",
                "workUnderProjectName",
                "Jan Kowalski",
                1L,
                LocalDateTime.now());
        SettlementGenerator settlementGenerator = new SettlementGenerator();
        FinancialSettlementManagerFacade financialSettlementManagerFacade = new FinancialSettlementManagerConfiguration().financialSettlementManagerFacadeForTest(financialSettlementRepository, settlementGenerator);
        //when
        FinancialSettlement financialSettlement = financialSettlementManagerFacade.createNewSettlement(financialSettlementDto);
        //then
        assertEquals("a","a");

    }

}

