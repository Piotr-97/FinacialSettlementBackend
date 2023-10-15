package s18746.financialsettlementbackend.financialsettelmentsmanager;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FinancialSettlementDto(String describe, BigDecimal amountOfMoney, String status, String companyName, String workUnderProjectName, String employeeName, Long employeeId, LocalDateTime date) {

    public FinancialSettlementDto(String describe,
                                  BigDecimal amountOfMoney,
                                  String companyName,
                                  String workUnderProjectName,
                                  String employeeName,
                                  Long employeeId,
                                  LocalDateTime date){
        this( describe, amountOfMoney, "pending", companyName, workUnderProjectName,  employeeName, employeeId,date);

    }
}
