package s18746.financialsettlementbackend.accountantmenager;

import lombok.Builder;
import s18746.financialsettlementbackend.financialsettelmentsmanager.FinancialSettlement;

import java.time.LocalDateTime;

@Builder
public record AnswerForSettlementDto( LocalDateTime createdDate, FinancialSettlement financialSettlement, String anwserForSettlement, SettlementAnswerStatus settlementAnswerStatus) {
}
