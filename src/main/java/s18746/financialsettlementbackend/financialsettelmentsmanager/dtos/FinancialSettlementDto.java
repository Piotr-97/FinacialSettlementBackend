package s18746.financialsettlementbackend.financialsettelmentsmanager.dtos;

import java.time.LocalDateTime;

public record FinancialSettlementDto(String uuid,
                                     String status,
                                     String settlementType,
                                     String projectId,
                                     String workId,
                                     String amountOfMoney,
                                     String description,
                                     String employeeId,
                                     String nameAndLastname,
                                     String date) {
}
