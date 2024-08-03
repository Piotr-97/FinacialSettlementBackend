package s18746.financialsettlementbackend.accountantmenager;

import s18746.financialsettlementbackend.financialsettelmentsmanager.dtos.FinancialSettlementDto;

public record AnswerForSettlementDtoResponse(String uuid,
                                             String date,
                                             String answerForSettlement,
                                             String settlementAnswerStatus,
                                             FinancialSettlementDto settlement) {
}
