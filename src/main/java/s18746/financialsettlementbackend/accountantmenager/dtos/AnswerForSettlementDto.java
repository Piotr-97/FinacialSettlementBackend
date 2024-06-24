package s18746.financialsettlementbackend.accountantmenager.dtos;

import lombok.Builder;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import java.time.LocalDateTime;

@Builder
public record AnswerForSettlementDto(String settlementUUID,
                                     String answerForSettlementUuid,
                                     String answerForSettlement,
                                     LocalDateTime createdAt,
                                     String settlementAnswerStatus,
                                     String employeeUuid,
                                     String employeeName) {
}
