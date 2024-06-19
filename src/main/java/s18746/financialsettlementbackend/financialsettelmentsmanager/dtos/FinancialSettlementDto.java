package s18746.financialsettlementbackend.financialsettelmentsmanager.dtos;

public record FinancialSettlementDto(String uuid,
                                     String status,
                                     String settlementType,
                                     String projectId,
                                     String workId,
                                     String amountOfMoney,
                                     String description,
                                     String employeeId,
                                     String nameAndLastname,
                                     java.time.LocalDateTime date) {
}
