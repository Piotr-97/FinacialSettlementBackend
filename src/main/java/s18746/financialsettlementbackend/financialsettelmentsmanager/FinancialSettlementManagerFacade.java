package s18746.financialsettlementbackend.financialsettelmentsmanager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FinancialSettlementManagerFacade {

    private final FinancialSettlementRepository financialSettlementRepository;
    private final SettlementGenerator settlementGenerator;


    public FinancialSettlement createNewSettlement() {
       return null;

    }
}
