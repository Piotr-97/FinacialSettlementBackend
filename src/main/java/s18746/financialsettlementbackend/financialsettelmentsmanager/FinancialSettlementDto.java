package s18746.financialsettlementbackend.financialsettelmentsmanager;

import java.math.BigDecimal;

public record FinancialSettlementDto(String describe,BigDecimal amountOfMoney, String status,String companyName,String workUnderProjectName, String firstname,Long employeeId) {
}
