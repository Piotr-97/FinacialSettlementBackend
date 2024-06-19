package s18746.financialsettlementbackend.financialsettelmentsmanager.dtos;

public record FinancialSettlementRequest(String settlementType,
                                         String projectId,
                                         String workId,
                                         String startAddress,
                                         String targetAddress,
                                         String country,
                                         String amountOfMoney,
                                         String description,
                                         String employeeId,
                                         String place) {
}
